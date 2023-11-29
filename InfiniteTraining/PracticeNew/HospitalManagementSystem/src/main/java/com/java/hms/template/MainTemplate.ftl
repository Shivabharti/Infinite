<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Bootstrap</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<header class="navbar navbar-inverse bs-docs-nav" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="./" class="navbar-brand">Bootstrap</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                [#-- Add li with a for each navbar item --]
                [#list this.navbar as content]${content.render()}[/#list]
            </ul>
            <ul class="nav navbar-nav navbar-right">
                [#-- Add li with a for each navbar_right item --]
                [#list this.navbar_right as content]${content.render()}[/#list]
            </ul>
        </nav>
    </div>
</header>

<main class="bs-masthead" id="content" role="main">
    <div class="container">
        [#list this.content as content]${content.render()}[/#list]
    </div>
</main>

<footer class="container" role="contentinfo">
    [#list this.footer as content]${content.render()}[/#list]
</footer>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="http://platform.twitter.com/widgets.js"></script>
</body>
</html>
