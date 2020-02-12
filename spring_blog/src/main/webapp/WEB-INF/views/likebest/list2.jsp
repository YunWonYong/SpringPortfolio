<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${list}" var="dto">
<table  id="treeData">
<tr>
<td width="30">
${dto.chartid }
</td>
<td  width="300">
<a href="${dto.thumbnail }">${dto.title }</a>
</td>
<td  width="100">
${dto.mlike }
</td>
<td  width="100">
${dto.week }
</td>
</tr>
</table>
</c:forEach>
