<html>
<body>
<h2>Application Tutoriel pour la base de données des hotels</h2>
<%@ page import="
   java.util.List,
    com.javaworld.hotels.businessobjects.Hotel,
    com.javaworld.hotels.model.HotelModel"
%>
<%
   HotelModel model = new HotelModel();
   String[] villes = model.trouveVillesDiponibles();
   String villeSelectionnee = request.getParameter("ville");
   List<Hotel> hotelList = model.trouveHotelsParVille(villeSelectionnee );
%>
   <h3>Choisissez une destination</h3>
   <form action="index.jsp" method="get">
     Merci de choisir une ville :
      <SELECT name="ville">
         <OPTION value="">---Toutes les villes ---</OPTION>
         <%
         for(String villeNom : villes ){
         %>
          <OPTION value="<%=villeNom %>"><%=villeNom %></OPTION>
         <%
         }
         %>
      </SELECT>
      <BUTTON type="submit">Chercher</BUTTON>
   </form>
   <% if (hotelList.size() > 0) { %>
      <h3>Hôtels disponibles à <%=villeSelectionnee %> </h3>
      <table border="1">
           <tr>
             <th>Nom</th>
             <th>Adresse</th>
             <th>Ville</th>
             <th>Catégorie</th>
            </tr>
         <%
         for(Hotel hotel : hotelList){
         %>
           <tr>
             <td><%=hotel.getNom()%></td>
             <td><%=hotel.getAdresse()%></td>
             <td><%=hotel.getVille()%></td>
             <td><%=hotel.getEtoiles()%> étoiles</td>
            </tr>
         <%
         }
         %>
       </table>
    <%}%>
</body>
</html>