<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h4>ZAMÓWIENIE NR ${id}</h4>
<h4>Data zamówienia: ${created}</h4>

<h4>Lista zamówienia</h4>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Cena</th>
        <th>ilość</th>
    </tr>
    <#list products as  key, value>
        <tr style="text-align: center">
            <td> ${key.name}</td>
            <td>${key.price} PLN</td>
            <td>${value}</td>
        </tr>
    </#list>
</table>
<br>
<b>Transport:</b> ${transportType} <b>-</b> ${transportPrice} PLN<br>

<br>

<b>Suma zamówienia:</b> ${orderSum} PLN<br>
<br>
<b>Płatność:</b> ${paymentMethod}<br>


<h4>Adres do wysyłki</h4>
<b>Imię:</b> ${adres.firstName} <br>
<b>Nazwisko:</b> ${adres.lastName}<br>
<b>Email:</b> ${adres.email}<br>
<b>Kraj:</b> ${adres.country}<br>
<b>Województwo:</b> ${adres.voivodeship}<br>
<b>Miasto:</b> ${adres.city}<br>
<b>Ulica:</b> ${adres.streetHome}<br>
<b>Kod pocztowy:</b> ${adres.postcode}<br>

</body>
</html>