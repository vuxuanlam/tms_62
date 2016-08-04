<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container text-center">
    <s:if test="hasActionErrors()">
        <div class="alert alert-danger" role="alert">
            <s:actionerror />
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <div class="alert alert-info" role="alert">
            <s:actionmessage />
        </div>
    </s:if>
    <sec:authorize access="!isAuthenticated()">
        <div class="jumbotron text-center">
            <h1>Hello :D</h1>
            <p>I am Training Management System</p>
            <p>Can I help you</p>
            <p>
                <a class="btn btn-primary btn-lg" href='<s:url value="/sign/signin"></s:url>'
                    role="button">Sign in</a>
            </p>
        </div>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVIOR')">
        <h3>
            <a href='<s:url value="courseadmin/viewallcourse"></s:url>' class="btn btn-default">Courses
                Manager</a>
        </h3>
        <h3>
            <a href='<s:url value="subjectadmin/viewallsubject"></s:url>' class="btn btn-default">Subject
                Manager</a>
        </h3>
        <h3>
            <a href='<s:url value="accountadmin/viewallaccount"></s:url>' class="btn btn-default">Account
                Manager</a>
        </h3>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <h3>
            <a href='<s:url value="courseuser/viewallcourse"></s:url>'>Courses Manager</a>
        </h3>
    </sec:authorize>
</div>
