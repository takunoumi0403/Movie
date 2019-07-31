<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画登録</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="regist_check" enctype="multipart/form-data" method="GET" name="form">
<table border="1">
<tr>
<th>映画の名前</th>
<td><input type="text" name="movie_name"></td>
</tr>
<tr>
<th>説明文 上映時間</th>
<td><input type="text" name="movie_description">
時間
<select name="movie_time_hour">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
</select>
分
<select name="movie_time_minute">
<option>0</option>
<option>10</option>
<option>20</option>
<option>30</option>
<option>40</option>
<option>50</option>
</select></td>
</tr>
<tr>
<th>上映開始日終了日</th>
<td>

<select name="movie_time_startyear">
<option>2019</option>
<option>2020</option>
<option>2021</option>
<option>2022</option>
<option>2023</option>
<option>2024</option>
<option>2025</option>
<option>2026</option>
</select>
年
<select name="movie_time_startmonth">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
</select>
月
<select name="movie_time_startday">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
<option>13</option>
<option>14</option>
<option>15</option>
<option>16</option>
<option>17</option>
<option>18</option>
<option>19</option>
<option>20</option>
<option>21</option>
<option>22</option>
<option>23</option>
<option>24</option>
<option>25</option>
<option>26</option>
<option>27</option>
<option>28</option>
<option>29</option>
<option>30</option>
<option>31</option>
</select>
日～
<select name="movie_time_endyear">
<option>2019</option>
<option>2020</option>
<option>2021</option>
<option>2022</option>
<option>2023</option>
<option>2024</option>
<option>2025</option>
<option>2026</option>
</select>
年
<select name="movie_time_endmonth">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
</select>
月
<select name="movie_time_endday">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
<option>13</option>
<option>14</option>
<option>15</option>
<option>16</option>
<option>17</option>
<option>18</option>
<option>19</option>
<option>20</option>
<option>21</option>
<option>22</option>
<option>23</option>
<option>24</option>
<option>25</option>
<option>26</option>
<option>27</option>
<option>28</option>
<option>29</option>
<option>30</option>
<option>31</option>
</select>
日
</td>
</tr>
<tr>
<th>シアター番号一覧</th>
<td>
<div class="form-block" id="form_block[0]">
第<select name="theater_number[0]" id="theater_number[0]" >
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
<option>13</option>
<option>14</option>
<option>15</option>
<option>16</option>
<option>17</option>
<option>18</option>
<option>19</option>
<option>20</option>
</select>
シアター

<button type="button" class="add">追加</button>
<div id="theaterNum"></div>
</div>
</td>
</tr>
<tr>
<th>上映開始時間帯</th>
<td>
<div class="form-block2" id="form_block2[0]">
第<span class="theater_Number"></span>シアター
<br>
<select name="theater_start_hour[0]">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
<option>13</option>
<option>14</option>
<option>15</option>
<option>16</option>
<option>17</option>
<option>18</option>
<option>19</option>
<option>20</option>
<option>21</option>
<option>22</option>
<option>23</option>
</select>
時
<select name="movie_time_minute[0]">
<option>0</option>
<option>5</option>
<option>10</option>
<option>15</option>
<option>20</option>
<option>25</option>
<option>30</option>
<option>35</option>
<option>40</option>
<option>45</option>
<option>50</option>
<option>55</option>
</select>
分
<button type="button" onclick="movieStartAdd();">追加</button>
<div id="movieStart"></div>
<div id="theaterStart"></div>
</div>
</td>
</tr>
<tr>
<th>HPアドレス</th>
<td>HPアドレス<input type="text" name="movie_address"></td>
</tr>

<tr>
<th>サムネイル</th>
<td>
<div class="imgInput">

<input type="file" name="file1">
<br>
</div>

</td>
</tr>
</table>
<input type="submit" value="送信"></form>
<!-- javascript読み込み -->
<script type="text/javascript" src="js/footerFixed.js"></script>
<!-- jQuery読み込み -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- サムネイル画像表示スクリプト -->
<script>
$(function(){
    var setFileInput = $('.imgInput');
 
    setFileInput.each(function(){
        var selfFile = $(this),
        selfInput = $(this).find('input[type=file]');
 
        selfInput.change(function(){
            var file = $(this).prop('files')[0],
            fileRdr = new FileReader(),
            selfImg = selfFile.find('.imgView');
 
            if(!this.files.length){
                if(0 < selfImg.size()){
                    selfImg.remove();
                    return;
                }
            } else {
                if(file.type.match('image.*')){
                    if(!(0 < selfImg.size())){
                        selfFile.append('<img alt="" class="imgView">');
                    }
                    var prevElm = selfFile.find('.imgView');
                    fileRdr.onload = function() {
                        prevElm.attr('src', fileRdr.result);
                    }
                    fileRdr.readAsDataURL(file);
                } else {
                    if(0 < selfImg.size()){
                        selfImg.remove();
                        return;
                    }
                }
            }
        });
    });
    var frm_cnt=0;
	$(document).on('click', 'button.add', function() {
		var original = $('#form_block\\['+frm_cnt+'\\]');
	    var originCnt = frm_cnt;
	    var originVal = $("select[name='theater_number\\[" + frm_cnt + "\\]']").val();

	    frm_cnt++;

	    original
        .clone()
        .hide()
        .insertAfter(original)
        .attr('id', 'form_block[' + frm_cnt + ']') // クローンのid属性を変更。
        .find('select').each(function(idx, obj) {
            $(obj).attr({
                id: $(obj).attr('id').replace(/\[[0-9]\]+$/, '[' + frm_cnt + ']'),
                name: $(obj).attr('name').replace(/\[[0-9]\]+$/, '[' + frm_cnt + ']')
            });
            $(obj).val('');
        });
	});
});
//シアター番号追加
/*function theaterAdd(){
    
    var div_element = document.createElement("div");
    div_element.innerHTML = '第<select name="theater_number"><option>0</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option><option>11</option><option>12</option><option>13</option><option>14</option><option>15</option><option>16</option><option>17</option><option>18</option><option>19</option><option>20</option></select> シアター <button type="button" onclick="theaterAdd();">追加</button>';
    var theater_object = document.getElementById("theaterNum");
    theater_object.appendChild(div_element);
    
    var div_element2 = document.createElement("div");
    div_element2.innerHTML = '第<span class="theaterNumber"></span>シアター<br><select name="theater_start_hour"><option>0</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option><option>11</option><option>12</option><option>13</option><option>14</option><option>15</option><option>16</option><option>17</option><option>18</option><option>19</option><option>20</option><option>21</option><option>22</option><option>23</option></select> 時 <select name="movie_time_minute"><option>0</option><option>5</option><option>10</option><option>15</option><option>20</option><option>25</option><option>30</option><option>35</option><option>40</option><option>45</option><option>50</option><option>55</option></select> 分 <button type="button" onclick="movieStartAdd();">追加</button><div id="movieStart"></div><div id="theaterStart"></div>'
    var theater_start_object = document.getElementById("theaterStart");
    theater_start_object.appendChild(div_element2);
}*/

//シアター番号追加時映画上映時間シアター番号に即反映
window.onload = function () {
    getValue();
    var $formObject = document.getElementById( "form" );
    $formObject.elements[11].onkeyup = function(){
    	getValue();
    }
    $formObject.elements[11].onchange = function(){
    	getValue();
    }
   
    
}
function getValue() {
    var $formObject = document.getElementById( "form" );
    document.getElementById( "theaterNumber" ).innerHTML = $formObject.theater_number.value;
   
}
/*window.onload = function () {
    getValue();
    var theater = document.getElementById( "theater_number" );
    theater.onkeyup = function(){getValue();};
    theater.onchange = function(){getValue();};
    
}
function getValue() {
    var $TN = document.getElementById( "form" );
    document.getElementById( "theaterNumber" ).innerHTML = $TN.theater_number.value;
    
}*/
//映画上映開始追加
function movieStartAdd(){
    var div_element = document.createElement("div");
    div_element.innerHTML = '<div id="Theater_Start"><select id="theater_start_hour" name="theater_start_hour"><option>0</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option><option>11</option><option>12</option><option>13</option><option>14</option><option>15</option><option>16</option><option>17</option><option>18</option><option>19</option><option>20</option><option>21</option><option>22</option><option>23</option></select> 時 <select id="theater_start_minute" name="movie_time_minute"><option>0</option><option>5</option><option>10</option><option>15</option><option>20</option><option>25</option><option>30</option><option>35</option><option>40</option><option>45</option><option>50</option><option>55</option></select> 分 <button type="button" onclick="movieStartDelete();">削除</button></div>';
    var movieStart_object = document.getElementById("movieStart");
    movieStart_object.appendChild(div_element);
}
//映画上映開始削除
function movieStartDelete(){
	var div_element=document.getcreateElement("div");
	var movieDelete_object=document.getElementById("Theater_Start")
	div_delete_element.removeChild(movieDelete_object);
	
}
</script>

</body>
</html>