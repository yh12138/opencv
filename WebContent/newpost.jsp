<%@include file="components/header.jsp" %>


    <div class="container">
       <%@include file="components/nav.jsp" %>

    </div>
    <br>

    <main role="main" class="container">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form class="form-horizontal" method="post" action="NewPostAction">
                    <div class="form-group">
                        <div class="row">
                            <label for="postTitle" class="col-sm-2 control-label">
                                Title:</label>
                            <div class="col-sm-10">
                                <input type="text" name="postTitle" id="postTitle" class="form-control" placeholder="Input a title" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <label for="postContent" class="col-sm-2 control-label">
                                Content:</label>
                            <div class="col-sm-10">
                                <textarea rows="24" name="postContent" id="postContent" class="form-control" placeholder="Write your contents (less than 3000 words, markdown grammar is supported)"
                                    required></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="offset-sm-2 col-sm-10">
                                <button class="btn btn-lg btn-primary" type="submit">Commit</button>
                                <button class="btn btn-lg btn-secondary" onclick="javascript:history.go(-1);">Cancel</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.row -->


    </main>
    <!-- /.container -->

    <%@include file="components/footer.jsp" %>