<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <div class="row">
        <h3 class="text-center">Edit Subject</h3>
        <div class="row text-center">
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
        <div class="col-md-8 col-md-offset-2">
            <s:form class="form-horizontal" method="POST"
                action="/subjectadmin/updatesubject?update=true">
                <div class="form-group">
                    <input type="hidden" name="subject.subjectId"
                        value="${subject.subjectId }"> <label for="name"
                        class="col-md-3 control-label">Name*</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" id="name"
                            name="subject.name" required="required"
                            value="${subject.name }">
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <label for="description" class="col-md-3 control-label">Description*</label>
                    <div class="col-md-9">
                        <textarea class="form-control" rows="3" id="description"
                            name="subject.description" required="required">${subject.description }</textarea>
                    </div>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-md-9">
                        <br>
                        <button type="submit" class="btn btn-primary btn-block">Update</button>
                    </div>
                </div>
            </s:form>
        </div>
    </div>
</div>
