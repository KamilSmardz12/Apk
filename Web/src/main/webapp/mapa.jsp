<%@ page import="Earthquakes.domain.Results" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>The nearest 10 eartquakes</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico"/>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
            integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
            crossorigin=""></script>
</head>

<body>
<div id="mapid" style="width: 1600px; height: 1200px;"></div>

<script th:inline="javascript">
    <%
         List<Results> list = (ArrayList<Results>)request.getAttribute("list");
         System.out.println(list);
    %>
    var x = <%=request.getParameter("x")%>;
    var y = <%=request.getParameter("y")%>;
    var mymap = L.map('mapid').setView([x, y], 6);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        maxZoom: 18,
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
            '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1
    }).addTo(mymap);

    <% for (Results result : list) { %>
    L.marker([<%=result.getLatitude()%>, <%=result.getLongitude()%>]).addTo(mymap)
        .bindPopup("<%=result.getPlace()%>")
        .openPopup();
    <%}%>

    L.marker([x,y]).addTo(mymap)
        .bindPopup("Main point (" + x + ", " + y + ")")
        .openPopup();

    L.circle([x, y],  <%=list.get(0).getDistance()*500%>, {
        color: 'red',
        fillColor: '#f03',
        fillOpacity: 0.4
    }).addTo(mymap).bindPopup("Zakres poszukiwań");

    // var popup = L.popup();
    //
    // function onMapClick(e) {
    //   popup
    //           .setLatLng(e.latlng)
    //           .setContent("You clicked the map at " + e.latlng.toString())
    //           .openOn(mymap);
    // }
    //
    // mymap.on('click', onMapClick);

</script>
</body>
</html>
