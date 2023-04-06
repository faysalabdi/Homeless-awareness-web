function display(val){
    var el = document.getElementsByClassName("allTables");
    for(i=0; i<el.length; i++) {
       el[i].style.display = "none";
      }
      document.getElementById(val).style.display = "table";
    }
    
    ///////////////////////////////////////////////

    function myFunction() {
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput");
      filter = input.value.toUpperCase();
      table1 = document.getElementById("table1");
      table2 = document.getElementById("table2");
      table3 = document.getElementById("table3");
      table3 = document.getElementById("table4");
      tr = table1.getElementsByTagName("tr");  
      for (i = 0; i < tr.length; i++) {
      
        var rowContent = tr[i].textContent;    
        rowContent = rowContent.replace(/[\s]+/g, ' ');
        //console.log(rowContent);    
      
        if (rowContent) {
          if (rowContent.toUpperCase().includes(filter)) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }  
        
      }
      table2 = document.getElementById("table2");
      tr = table2.getElementsByTagName("tr"); 
      for (i = 0; i < tr.length; i++) {
      
        var rowContent = tr[i].textContent;    
        rowContent = rowContent.replace(/[\s]+/g, ' ');
        //console.log(rowContent);    
      
        if (rowContent) {
          if (rowContent.toUpperCase().includes(filter)) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }  
        
      }

      table3 = document.getElementById("table3");
      tr = table3.getElementsByTagName("tr"); 
      for (i = 0; i < tr.length; i++) {
      
        var rowContent = tr[i].textContent;    
        rowContent = rowContent.replace(/[\s]+/g, ' ');
        //console.log(rowContent);    
      
        if (rowContent) {
          if (rowContent.toUpperCase().includes(filter)) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }  
        
      }


      table4 = document.getElementById("table4");
      tr = table4.getElementsByTagName("tr"); 
      for (i = 0; i < tr.length; i++) {
      
        var rowContent = tr[i].textContent;    
        rowContent = rowContent.replace(/[\s]+/g, ' ');
        //console.log(rowContent);    
      
        if (rowContent) {
          if (rowContent.toUpperCase().includes(filter)) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }  
        
      }

    }
    