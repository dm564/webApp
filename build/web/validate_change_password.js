function validate_change_password(f){
  
   old=f.data2.value;
   newp=f.data3.value;
   rnewp=f.data4.value;
   cap=f.data5.value;
   spn=document.getElementById("err");
   if (old=="")
   {
       alert("Enter the old Password");
       f.data2.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (newp=="")
   {
       alert("Enter the Password");
       f.data3.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (rnewp=="")
   {
       alert("Enter the password");
       f.data4.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (cap=="")
   {
       alert("Enter captcha");
       f.data5.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
   if(newp!=rnewp)
   {
       alert("PassWord did NOT matched");
       f.data4.focus();
       spn.innerHTML="Entered Password did not matched";
       return false;
   }
    
}