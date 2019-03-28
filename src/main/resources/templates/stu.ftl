<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8" />
<title></title>
</head>
<body>
	  欢迎${loginName}
	  <#if age <= 17>小哥
	  <#elseif age <= 30>先生
	  <#else>大叔
	  </#if>登录
</body> 
</html>