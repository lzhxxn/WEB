<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>

<section>
  <!--for demo wrap-->
  <h1>Fixed Table header</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>NAME</th>
          <th>EMAIL</th>
          <th>PHONE</th>
          <th>ADDR</th>
		  <th>GRADE</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <tr>
          <td>${dto.name}</td>
          <td>${dto.email}</td>
          <td>${dto.phone}</td>
          <td>${dto.addr}</td>
          <td>${dto.grade}</td>
        </tr>
      </tbody>
    </table>
  </div>
</section>
<!-- follow me template -->
<div class="made-with-love">
  신촌 비트캠프 5조
  <i>♥</i>
  <a target="_blank" href="https://codepen.io/nikhil8krishnan">남정네들</a>
</div>