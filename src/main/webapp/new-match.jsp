<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Match</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<h1>New Match</h1>
<div class="container">
    <form action="${pageContext.request.contextPath}/new-match" method="post">
        <p>
            <label>
                First Player
                <input type="text" name="firstPlayerName">
            </label>
        </p>
        <p>
            <label>
                Second Player
                <input type="text" name="secondPlayerName">
            </label>
        </p>
        <p>
            <input type="submit" value="Start Match">
        </p>
    </form>
</div>
</body>

</html>
