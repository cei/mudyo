<#assign s=JspTaglibs["http://www.springframework.org/tags"] />
<#assign cei=JspTaglibs["http://www.cheoeumin.com/tags/ui"] />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>check</title>
	<link rel="shortcut-icon" type="image/x-icon" href="/favicon.ico" />
<body>
	<@s.message code="confirm.execute" />
	<@cei.select items=list />
	${timeToDate?string("yyyy-MM-dd HH:mm:ss.SSS")}
</body>
</html>