<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="BOOTSTRAP/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="BOOTSTRAP/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="BOOTSTRAP/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="BOOTSTRAP/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark  border-bottom border-dark static-top" style="background-color: #ADD8E6">

    <a  href="/" style="float:right; line-height: 12px"><img src="BOOTSTRAP/logo4.png" style="float: left; margin-bottom: 0px"></a>

    <button class="btn btn-link btn-lg text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>


    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </div>
    </form>
    <ul class="navbar-nav ml-auto ml-md-0">
        <c:if test="${not empty sessionScope.username}">
            <li class="nav-item dropdown no-arrow mx-1">
                <i class="fas fa-user-tie"></i>
                    Logged as ${sessionScope.username}
                </a>
            </li>
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle text-dark" href="/admin/logout" role="button"  aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-sign-out-alt"></i>
                    Log out
                </a>
            </li>

        </c:if>

    </ul>




    <li class="nav-item dropdown no-arrow mx-1">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-tie"></i>
            Logged as Bruno Kedzierski
        </a>
    </li>


</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Menu</span>
            </a>
        </li>
        <li class="nav-item ">
            <a class="nav-link " href="/customer-show" >
                <i class="fas fa-fw fa-users"></i>
                <span>Clients</span>
            </a>

        </li>
        <li class="nav-item ">
            <a class="nav-link " href="/vehicles-show" >
                <i class="fas fa-car-alt"></i>
                <span>Vehicles</span>
            </a>

        </li>
        <li class="nav-item">
            <a class="nav-link" href="/orders-show">
                <i class="fas fa-fw fa-list-alt"></i>
                <span>Orders</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/employees-show">
                <i class="fas fa-fw fa-user-astronaut"></i>
                <span>Employees</span></a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle"  id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-fw fa-chart-pie"></i>
                <span>Reports</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <a class="dropdown-item" href="/report-profits"><i class="fas fa-hand-holding-usd"></i> <span>Profit report</span></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/report-manhours"><i class="fas fa-clock"></i> <span>Manhours report</span> </a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">
                <i class="fas fa-fw fa-sign-out-alt"></i>
                <span>Logout</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/help.jsp">
                <i class="fas fa-fw fa-question-circle"></i>
                <span>Help</span></a>
        </li>
        <li class="nav-item" style="margin-top: 300px; margin-left: 15px">
            <a class="nav-link" href="/help.jsp">
                <i class="fab fa-java fa-10x"></i><a/>
            </a>
        </li>

    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">