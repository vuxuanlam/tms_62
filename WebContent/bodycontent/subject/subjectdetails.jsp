<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
    <h2 class="text-center">Subjects Details</h2>
    <hr>
    <div class="row">
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
    </div>
    <div class=col-md-6>
        <div class="panel panel-default">
            <div class="panel-heading">Subject details</div>
            <div class="panel-body">
                <strong>Subject Name: </strong>
                <p>${subject.name }</p>
                <strong>Subject Description: </strong>
                <p>${subject.description }</p>
                <strong>Create At: </strong>
                <p>
                    <s:date name="subject.createAt" format="dd/MM/yyyy" />
                </p>
                <strong>Update At: </strong>
                <p>
                    <s:date name="subject.updateAt" format="dd/MM/yyyy" />
                </p>
                <s:url action="updatesubject" var="updateSubject">
                    <s:param name="subject.subjectId">${subject.subjectId }</s:param>
                </s:url>
                <a href="${updateSubject }" class="btn btn-primary">Edit</a>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="panel panel-info">
            <div class="panel-heading">List tasks of Subject</div>
            <div class="panel-body">
                <s:iterator value="subject.listTasks" var="task">
                    <div class="row">
                        <div class="col-md-8">${task.name }</div>
                        <div class="col-md-4">
                            <s:url value="/taskadmin/removetask" var="removetasklink">
                                <s:param name="task.taskId">${task.taskId }</s:param>
                            </s:url>
                            <a href='${removetasklink }'>Remove</a>
                        </div>
                    </div>
                </s:iterator>
                <hr>
                <div class="row">
                    <s:form action="/taskadmin/addtask" method="post">
                        <input type="hidden" name="subject.subjectId" value="${subject.subjectId }" />
                        <div class="col-md-3">
                            <input type="text" name="task.name" placeholder="Task Name"
                                class="form-control" />
                        </div>
                        <div class="col-md-7">
                            <input type="text" name="task.description" placeholder="Description"
                                class="form-control" />
                        </div>
                        <div class="col-md-2">
                            <input type="submit" value="Add" class="form-control btn btn-primary" />
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </div>
</div>