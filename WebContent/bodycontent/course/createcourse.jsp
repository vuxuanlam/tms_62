<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
    <h3 class="text-center">Create Course</h3>
    <div class="col-md-5 col-md-offset-3">
        <s:form class="form-horizontal" method="POST"
            action="/courseadmin/createcourse">
            <div class="form-group">
                <label for="coursename">Name</label> <input type="text"
                    class="form-control" id="coursename"
                    name="currentCourse.name">
            </div>
            <div class="form-group">
                <label for="coursedescription">Description</label> <input
                    type="text" class="form-control" id="coursedescription"
                    name="currentCourse.description">
            </div>

            <div class="form-group">
                <label for="startdate">Start date</label> <input type="date"
                    class="form-control" id="startdate"
                    name="currentCourse.startDate">
            </div>
            <div class="form-group">
                <label for="enddate">End date</label> <input type="date"
                    class="form-control" id="enddate"
                    name="currentCourse.endDate">
            </div>
            <s:if test="listSubjects">
                <tr>
                    <s:iterator value="listSubjects">
                        <div class="checkbox">
                            <label> <input type="checkbox"
                                name="subject.subjectId" value="${subjectId }">
                                ${name }
                            </label>
                        </div>
                    </s:iterator>
                </tr>
            </s:if>
            <button type="submit" class="btn btn-default">Submit</button>
        </s:form>
    </div>
</div>
