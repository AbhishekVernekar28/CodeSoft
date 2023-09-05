<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Guess the Number Game</title>
</head>
<body>
    <h1>Guess the Number Game</h1>
    
    <% String message = (String) request.getAttribute("message"); %>
    <% int score = (int) request.getAttribute("score"); %>
    <% int attemptsLeft = (int) request.getAttribute("attemptsLeft"); %>
    
    <p><%= message %></p>
    
    <form action="GuessNumberServlet" method="get">
        <label for="guess">Enter your guess:</label>
        <input type="number" name="guess" id="guess" required>
        <input type="submit" value="Guess">
    </form>
    
    <p>Attempts left: <%= attemptsLeft %></p>
    <p>Score: <%= score %></p>
</body>
</html>
