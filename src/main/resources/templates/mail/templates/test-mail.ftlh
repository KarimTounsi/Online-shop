<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>



<#list products as  key, value>
  ${key.name} = ${value}
</#list>
</body>
</html>