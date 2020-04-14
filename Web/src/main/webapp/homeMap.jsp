<html lang="pl">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>
    <title>Main page </title>
    <link href="home/css/bootstrap.css" rel="stylesheet"/>
    <link href="home/css/coming-sssoon.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
</head>

<body>
<nav class="navbar navbar-transparent navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="Home.html">
                        Main page
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h1>Sklep internetowy</h1>
<form action="/MapaServlet" method="get">
    <input name="x" placeholder="x">
    <br/>
    <input name="y" placeholder="y">
    <br/>
    <input type="submit" value="Pokaz">
</form>
<div class="footer">
    <div class="container">
        K.S.
    </div>
</div>
</body>
</html>