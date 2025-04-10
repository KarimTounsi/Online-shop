//package pl.coderslab.project.product.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import pl.coderslab.project.category.entity.Category;
//import pl.coderslab.project.product.entity.Product;
//import pl.coderslab.project.product.repository.ProductRepository;
//import pl.coderslab.project.product.service.ProductService;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//class ProductServiceImplTest {
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    private ProductRepository productRepository;
//    private ProductService productService;
//    private List<Product> expectResult1;
//    private String name1;
//    private List<Product> returnObject1;
//    private String name2;
//
//    @BeforeEach
//    void getProductsByNameContainingVariableInit() {
//        name1 = "";
//// Add Jason
//        String expectResult1Jason="";
//        name2 = "";
//// Add Jason
//        String returnObject1Jason="";
//        try {
//            expectResult1= objectMapper.readValue(expectResult1Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject1= objectMapper.readValue(returnObject1Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByNameContaining() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndNameContaining(name2)).thenReturn( returnObject1);
//        assertEquals(expectResult1, productService.getProductsByNameContaining(name1));
//    }
//
//    private List<Product> expectResult2;
//    private List<Product> returnObject2;
//
//    @BeforeEach
//    void getAllVariableInit() {
//// Add Jason
//        String expectResult2Jason="";
//// Add Jason
//        String returnObject2Jason="";
//        try {
//            expectResult2= objectMapper.readValue(expectResult2Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject2= objectMapper.readValue(returnObject2Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAll() {
//        Mockito.when(productRepository.findAll()).thenReturn( returnObject2);
//        assertEquals(expectResult2, productService.getAll());
//    }
//
//    private List<Product> expectResult3;
//    private boolean status3;
//    private List<Product> returnObject3;
//    private boolean status4;
//
//    @BeforeEach
//    void getAllByStatusVariableInit() {
//// Add Jason
//        String status3Jason="";
//// Add Jason
//        String expectResult3Jason="";
//// Add Jason
//        String status4Jason="";
//// Add Jason
//        String returnObject3Jason="";
//        try {
//            expectResult3= objectMapper.readValue(expectResult3Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            status3= objectMapper.readValue(status3Jason, boolean.class);
//            status4= objectMapper.readValue(status4Jason, boolean.class);
//            returnObject3= objectMapper.readValue(returnObject3Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAllByStatus() {
//        Mockito.when(productRepository.findAllByStatus(status4)).thenReturn( returnObject3);
//        assertEquals(expectResult3, productService.getAllByStatus(status3));
//    }
//
//    private List<Product> expectResult4;
//    private Category category5;
//    private List<Product> returnObject4;
//    private Category category6;
//
//    @BeforeEach
//    void productsByCategoryVariableInit() {
//// Add Jason
//        String category5Jason="";
//// Add Jason
//        String expectResult4Jason="";
//// Add Jason
//        String category6Jason="";
//// Add Jason
//        String returnObject4Jason="";
//        try {
//            expectResult4= objectMapper.readValue(expectResult4Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            category5= objectMapper.readValue(category5Jason, Category.class);
//            category6= objectMapper.readValue(category6Jason, Category.class);
//            returnObject4= objectMapper.readValue(returnObject4Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void productsByCategory() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndCategory(category6)).thenReturn( returnObject4);
//        assertEquals(expectResult4, productService.productsByCategory(category5));
//    }
//
//    private Product expectResult5;
//    private Long id7;
//    private Product product;
//
//    @BeforeEach
//    void getProductByIdVariableInit() {
//        id7=1L;
//// Add Jason
//        String expectResult5Jason="";
//// Add Jason
//        String productJason="";
//        try {
//            expectResult5= objectMapper.readValue(expectResult5Jason, Product.class);
//            product= objectMapper.readValue(productJason, Product.class);
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductById() {
//        Mockito.when(productRepository.findById(id7)).thenReturn( product);
//        assertEquals(expectResult5, productService.getProductById(id7));
//    }
//
//    private Optional<Product> expectResult6;
//    private Long id8;
//    private Optional<Product> returnObject5;
//    private Long id9;
//
//    @BeforeEach
//    void findByIdVariableInit() {
//        id8=2L;
//// Add Jason
//        String expectResult6Jason="";
//        id9=3L;
//// Add Jason
//        String returnObject5Jason="";
//    }
//
//    @Test
//    void findById() {
//        Mockito.when(productRepository.findById(id9)).thenReturn( returnObject5);
//        assertEquals(expectResult6, productService.findById(id8));
//    }
//
//    private List<Product> expectResult7;
//    private List<Product> returnObject6;
//
//    @BeforeEach
//    void getAllByOrderByPriceAscVariableInit() {
//// Add Jason
//        String expectResult7Jason="";
//// Add Jason
//        String returnObject6Jason="";
//        try {
//            expectResult7= objectMapper.readValue(expectResult7Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject6= objectMapper.readValue(returnObject6Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAllByOrderByPriceAsc() {
//        Mockito.when(productRepository.findAllByStatusTrueOrderByPriceAsc()).thenReturn( returnObject6);
//        assertEquals(expectResult7, productService.getAllByOrderByPriceAsc());
//    }
//
//    private List<Product> expectResult8;
//    private List<Product> returnObject7;
//
//    @BeforeEach
//    void getAllByOrderByPriceDescVariableInit() {
//// Add Jason
//        String expectResult8Jason="";
//// Add Jason
//        String returnObject7Jason="";
//        try {
//            expectResult8= objectMapper.readValue(expectResult8Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject7= objectMapper.readValue(returnObject7Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAllByOrderByPriceDesc() {
//        Mockito.when(productRepository.findAllByStatusTrueOrderByPriceDesc()).thenReturn( returnObject7);
//        assertEquals(expectResult8, productService.getAllByOrderByPriceDesc());
//    }
//
//    private List<Product> expectResult9;
//    private List<Product> returnObject8;
//
//    @BeforeEach
//    void getAllByOrderByNameAscVariableInit() {
//// Add Jason
//        String expectResult9Jason="";
//// Add Jason
//        String returnObject8Jason="";
//        try {
//            expectResult9= objectMapper.readValue(expectResult9Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject8= objectMapper.readValue(returnObject8Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAllByOrderByNameAsc() {
//        Mockito.when(productRepository.findAllByStatusTrueOrderByNameAsc()).thenReturn( returnObject8);
//        assertEquals(expectResult9, productService.getAllByOrderByNameAsc());
//    }
//
//    private List<Product> expectResult10;
//    private List<Product> returnObject9;
//
//    @BeforeEach
//    void getAllByOrderByNameDscVariableInit() {
//// Add Jason
//        String expectResult10Jason="";
//// Add Jason
//        String returnObject9Jason="";
//        try {
//            expectResult10= objectMapper.readValue(expectResult10Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject9= objectMapper.readValue(returnObject9Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getAllByOrderByNameDsc() {
//        Mockito.when(productRepository.findAllByStatusTrueOrderByNameDesc()).thenReturn( returnObject9);
//        assertEquals(expectResult10, productService.getAllByOrderByNameDsc());
//    }
//
//    private List<Product> expectResult11;
//    private String name10;
//    private List<Product> returnObject10;
//    private String name11;
//
//    @BeforeEach
//    void getProductsByNameIsStartingWithOrderByPriceAscVariableInit() {
//        name10 = "";
//// Add Jason
//        String expectResult11Jason="";
//        name11 = "";
//// Add Jason
//        String returnObject10Jason="";
//        try {
//            expectResult11= objectMapper.readValue(expectResult11Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject10= objectMapper.readValue(returnObject10Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByNameIsStartingWithOrderByPriceAsc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByPriceAsc(name11)).thenReturn( returnObject10);
//        assertEquals(expectResult11, productService.getProductsByNameIsStartingWithOrderByPriceAsc(name10));
//    }
//
//    private List<Product> expectResult12;
//    private String name12;
//    private List<Product> returnObject11;
//    private String name13;
//
//    @BeforeEach
//    void getProductsByNameIsStartingWithOrderByPriceDescVariableInit() {
//        name12 = "";
//// Add Jason
//        String expectResult12Jason="";
//        name13 = "";
//// Add Jason
//        String returnObject11Jason="";
//        try {
//            expectResult12= objectMapper.readValue(expectResult12Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject11= objectMapper.readValue(returnObject11Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByNameIsStartingWithOrderByPriceDesc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByPriceDesc(name13)).thenReturn( returnObject11);
//        assertEquals(expectResult12, productService.getProductsByNameIsStartingWithOrderByPriceDesc(name12));
//    }
//
//    private List<Product> expectResult13;
//    private String name14;
//    private List<Product> returnObject12;
//    private String name15;
//
//    @BeforeEach
//    void getProductsByNameIsStartingWithOrderByNameAscVariableInit() {
//        name14 = "";
//// Add Jason
//        String expectResult13Jason="";
//        name15 = "";
//// Add Jason
//        String returnObject12Jason="";
//        try {
//            expectResult13= objectMapper.readValue(expectResult13Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject12= objectMapper.readValue(returnObject12Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByNameIsStartingWithOrderByNameAsc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByNameAsc(name15)).thenReturn( returnObject12);
//        assertEquals(expectResult13, productService.getProductsByNameIsStartingWithOrderByNameAsc(name14));
//    }
//
//    private List<Product> expectResult14;
//    private String name16;
//    private List<Product> returnObject13;
//    private String name17;
//
//    @BeforeEach
//    void getProductsByNameIsStartingWithOrderByNameDescVariableInit() {
//        name16 = "";
//// Add Jason
//        String expectResult14Jason="";
//        name17 = "";
//// Add Jason
//        String returnObject13Jason="";
//        try {
//            expectResult14= objectMapper.readValue(expectResult14Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject13= objectMapper.readValue(returnObject13Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByNameIsStartingWithOrderByNameDesc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndNameIsStartingWithOrderByNameDesc(name17)).thenReturn( returnObject13);
//        assertEquals(expectResult14, productService.getProductsByNameIsStartingWithOrderByNameDesc(name16));
//    }
//
//    private List<Product> expectResult15;
//    private Category category18;
//    private List<Product> returnObject14;
//    private Category category19;
//
//    @BeforeEach
//    void getProductsByCategoryOrderByPriceAscVariableInit() {
//// Add Jason
//        String category18Jason="";
//// Add Jason
//        String expectResult15Jason="";
//// Add Jason
//        String category19Jason="";
//// Add Jason
//        String returnObject14Jason="";
//        try {
//            expectResult15= objectMapper.readValue(expectResult15Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            category18= objectMapper.readValue(category18Jason, Category.class);
//            category19= objectMapper.readValue(category19Jason, Category.class);
//            returnObject14= objectMapper.readValue(returnObject14Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByCategoryOrderByPriceAsc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndCategoryOrderByPriceAsc(category19)).thenReturn( returnObject14);
//        assertEquals(expectResult15, productService.getProductsByCategoryOrderByPriceAsc(category18));
//    }
//
//    private List<Product> expectResult16;
//    private Category category20;
//    private List<Product> returnObject15;
//    private Category category21;
//
//    @BeforeEach
//    void getProductsByCategoryOrderByPriceDescVariableInit() {
//// Add Jason
//        String category20Jason="";
//// Add Jason
//        String expectResult16Jason="";
//// Add Jason
//        String category21Jason="";
//// Add Jason
//        String returnObject15Jason="";
//        try {
//            expectResult16= objectMapper.readValue(expectResult16Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            category20= objectMapper.readValue(category20Jason, Category.class);
//            category21= objectMapper.readValue(category21Jason, Category.class);
//            returnObject15= objectMapper.readValue(returnObject15Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByCategoryOrderByPriceDesc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndCategoryOrderByPriceDesc(category21)).thenReturn( returnObject15);
//        assertEquals(expectResult16, productService.getProductsByCategoryOrderByPriceDesc(category20));
//    }
//
//    private List<Product> expectResult17;
//    private Category category22;
//    private List<Product> returnObject16;
//    private Category category23;
//
//    @BeforeEach
//    void getProductsByCategoryOrderByNameAscVariableInit() {
//// Add Jason
//        String category22Jason="";
//// Add Jason
//        String expectResult17Jason="";
//// Add Jason
//        String category23Jason="";
//// Add Jason
//        String returnObject16Jason="";
//        try {
//            expectResult17= objectMapper.readValue(expectResult17Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            category22= objectMapper.readValue(category22Jason, Category.class);
//            category23= objectMapper.readValue(category23Jason, Category.class);
//            returnObject16= objectMapper.readValue(returnObject16Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByCategoryOrderByNameAsc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndCategoryOrderByNameAsc(category23)).thenReturn( returnObject16);
//        assertEquals(expectResult17, productService.getProductsByCategoryOrderByNameAsc(category22));
//    }
//
//    private List<Product> expectResult18;
//    private Category category24;
//    private List<Product> returnObject17;
//    private Category category25;
//
//    @BeforeEach
//    void getProductsByCategoryOrderByNameDescVariableInit() {
//// Add Jason
//        String category24Jason="";
//// Add Jason
//        String expectResult18Jason="";
//// Add Jason
//        String category25Jason="";
//// Add Jason
//        String returnObject17Jason="";
//        try {
//            expectResult18= objectMapper.readValue(expectResult18Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            category24= objectMapper.readValue(category24Jason, Category.class);
//            category25= objectMapper.readValue(category25Jason, Category.class);
//            returnObject17= objectMapper.readValue(returnObject17Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getProductsByCategoryOrderByNameDesc() {
//        Mockito.when(productRepository.findProductsByStatusTrueAndCategoryOrderByNameDesc(category25)).thenReturn( returnObject17);
//        assertEquals(expectResult18, productService.getProductsByCategoryOrderByNameDesc(category24));
//    }
//
//    private List<Product> expectResult19;
//    private List<Product> returnObject18;
//
//    @BeforeEach
//    void getLastSixProductsVariableInit() {
//// Add Jason
//        String expectResult19Jason="";
//// Add Jason
//        String returnObject18Jason="";
//        try {
//            expectResult19= objectMapper.readValue(expectResult19Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//            returnObject18= objectMapper.readValue(returnObject18Jason, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        } catch (JsonProcessingException e) {
//
//            e.printStackTrace();
//
//        }}
//
//    @Test
//    void getLastSixProducts() {
//        Mockito.when(productRepository.findAllByStatusTrueOrderByIdDesc()).thenReturn( returnObject18);
//        assertEquals(expectResult19, productService.getLastSixProducts());
//    }
//
//}