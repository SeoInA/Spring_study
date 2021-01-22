<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
    <div class="card">
      <div class="card-header border-0">회원가입</div>
      
      	<h3>환영합니다 :)</h3>
        <div class="card-body">
       <form method="post">
        <div class="form-group row">
          <input type="text" id="email_address" class="form-control"
          name="email">
        </div>
         <div class="form-group row">
          <input type="password" id="password" class="form-control"
          name="password">
          </div>		
          <div class="form-group row">
            <input type="text" id="name" class="form-control"
            name="name">
          </div>
          <button type="submit" class="btn btn-primary">회원가입</button>
        </div>
      </form>
    </div>
  </body>
</html>