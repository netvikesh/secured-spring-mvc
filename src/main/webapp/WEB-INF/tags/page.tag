<%@ tag description="Page Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageCss" fragment="true" required="false" %>
<%@ attribute name="pageJs" fragment="true" required="false" %>
<!DOCTYPE html>
<html lang="${not empty lang?lang:'en'}">
<global:head/>
<global:style/>
<body>
<jsp:doBody/>
<global:js/>
<jsp:invoke fragment="pageJs"/>
</body>
</html>