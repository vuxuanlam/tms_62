<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<s:url value="/"></s:url>'>FRAMGIA TRAINING SYSTEM</a>
            <sec:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false"><span class="caret"></span> <sec:authentication
                                property="principal.username" /></a>
                        <ul class="dropdown-menu">
                            <li><a href='<s:url value="#"></s:url>'><i
                                    class="glyphicon glyphicon-user"></i>&nbsp;Profile</a></li>
                            <li><a href="tms_62/j_spring_security_logout"><i
                                    class="glyphicon glyphicon-off"></i>&nbsp;Sign out</a></li>
                        </ul></li>
                </ul>
            </sec:authorize>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
