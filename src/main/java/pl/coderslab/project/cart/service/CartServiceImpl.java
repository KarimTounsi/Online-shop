package pl.coderslab.project.cart.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pl.coderslab.project.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.order.entity.Order;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();

    @Autowired(required = false)
    private JavaMailSender mailSender;


    @Override
    public void addProduct(Product product) throws NotEnoughProductsInStockException {

        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
        if (product.getQuantity() -1 < products.get(product)){
            products.replace(product, products.get(product) - 1);
            throw new NotEnoughProductsInStockException(product);
        }
    }



    @Override
    public void removeProduct(Product product) {

            products.remove(product);

    }

    @Override
    public void subtractProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }


    @Override
    public void checkout() throws NotEnoughProductsInStockException {
        Product product;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            product = productRepository.getOne(entry.getKey().getId());
            if (product.getQuantity() < entry.getValue()){
                throw new NotEnoughProductsInStockException(product);
            }
            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
        }
        productRepository.saveAll(products.keySet());
        productRepository.flush();
        products.clear();
    }



    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }



    @Override
    public BigDecimal getTotal() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public int getAmountProductsInCart() {
            return products.size();

    }

//    @Scheduled(cron = "0 * * * * *")

    public void sendToClientMail(Order order) throws MessagingException, IOException, TemplateException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/mail/templates");
        Configuration config = freeMarkerConfigurer.createConfiguration();
        Template mailTemplate = config.getTemplate("email-to-client.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("id", order.getId());
        model.put("created", order.getCreated());
        model.put("adres", order.getAddress());
        model.put("products", Map.copyOf(order.getProducts()));
        model.put("transportType", order.getTransportType());
        model.put("transportPrice", order.getTransportPrice());
        model.put("orderSum", order.getOrderSum());
        model.put("paymentMethod", order.getPaymentMethod());

        String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, model);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("karim.tounsi100@gmail.com");
        messageHelper.setSubject("ImStore - zamówienie Nr: "+order.getId());
        messageHelper.setBcc(new String[]{order.getAddress().getEmail()});
        messageHelper.setText(mailBody, true);
        mailSender.send(mimeMessage);


    }

    @Override
    public void sendToAdminMail(Order order) throws MessagingException, IOException, TemplateException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/mail/templates");
        Configuration config = freeMarkerConfigurer.createConfiguration();
        Template mailTemplate = config.getTemplate("email-to-admin.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("id", order.getId());
        model.put("created", order.getCreated());
        model.put("adres", order.getAddress());
        model.put("products", Map.copyOf(order.getProducts()));
        model.put("transportType", order.getTransportType());
        model.put("transportPrice", order.getTransportPrice());
        model.put("orderSum", order.getOrderSum());
        model.put("paymentMethod", order.getPaymentMethod());

        String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, model);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        messageHelper.setFrom("karim.tounsi100@gmail.com");
        messageHelper.setSubject("ImStore - zamówienie Nr: "+order.getId());
        messageHelper.setBcc(new String[]{"karim.tounsi100@gmail.com"});
        messageHelper.setText(mailBody, true);
        mailSender.send(mimeMessage);
    }

}
