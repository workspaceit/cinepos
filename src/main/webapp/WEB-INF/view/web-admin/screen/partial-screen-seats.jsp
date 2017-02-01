<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 2/1/17
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<div id="content-8" class="content seat-assemble">
  <div class="seats-container">
    <table class="seat-table">
      <tbody>
      <d:set var="newSeatCount" value="${0}"></d:set>
      <d:set var="newSeatId" value=""></d:set>
      <d:forEach var="screenRow" items="${screenSeatList}">
        <tr>
          <d:forEach  var="seat" items="${screenRow}" >
            <d:if test="${seat.id==0}" >
              <d:set var="newSeatCount" value="${newSeatCount+1}"></d:set>
              <d:set var="newSeatId" value="new_${newSeatCount}"></d:set>
            </d:if>
            <td>
              <div class="seat-single">
                <a class="seatInfHolder" id="seat_${newSeatId}${seat.id}" href="#" onclick="showSeatDetailsModal(this)"
                   data-seat='{"id":${seat.id},
                                                        "name":"${seat.name}",
                                                        "seatType":{"id":${seat.seatType.id}}}'

                        >${seat.name}</a>
              </div>
            </td>
            <d:set var="newSeatId" value=""></d:set>
          </d:forEach>
        </tr>
      </d:forEach>

      </tbody>


    </table>
  </div>
</div>
