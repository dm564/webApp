function validate(f){
  
   fname=f.data1.value;
   lname=f.data2.value;
   email=f.data3.value;
   pass=f.data4.value;
   repass=f.data5.value;
   gender=f.data6.value;
   country=f.data7.value;
   spn=document.getElementById("err");
   if(fname=="")
   {
       alert("Enter the First Name");
       f.data1.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
   if (lname=="")
   {
       alert("Enter the Last Name");
       f.data1.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (email=="")
   {
       alert("Enter the email");
       f.data1.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (pass=="")
   {
       alert("Enter the password");
       f.data1.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
    if (repass=="")
   {
       alert("Enter the Last re-type password");
       f.data1.focus();
       spn.innerHTML="Please Fill all the Entry";
       return false;
   }
   if(pass!=repass)
   {
       alert("PassWord did NOT matched");
       f.data4.focus();
       spn.innerHTML="Entered Password did not matched";
       return false;
   }
   for(i=0;i<fname.length;i++){
       ch=fname.charAt(i);
       if(!((ch<='z'&& ch>='a')||(ch<='Z'&& ch>='A')))
       {
           alert("INVALID NAME");
           spn.innerHTML="Pleas Fill a valid Name";
           f.data1.focus();
           return false;
        }
   }
   for(i=0;i<lname.length;i++){
       ch=lname.charAt(i);
       if(!((ch<='z'&& ch>='a')||(ch<='Z'&& ch>='A')))
       {
           alert("INVALID NAME");
           spn.innerHTML="Pleas Fill a valid Name";
           f.data2.focus();
           return false;
        }
    } 
}