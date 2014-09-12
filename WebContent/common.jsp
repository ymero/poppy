<%@ page contentType="text/html;charset=utf-8"%>
<% 
String path = request.getContextPath(); 
String basePath = path + "/";
%>
<script type="text/javascript">
	var basePath = '<%=basePath%>';

</script>
<html>
	<%=basePath %>
</html>
