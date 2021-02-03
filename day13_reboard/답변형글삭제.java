< 삭제 >

1. 원래글 삭제 (idx) 
   where refer=(select refer from board where idx=?)

2. 자식글 삭제 (idx) 
   (1) select refer, lev, sunbun where idx=?  
      => refer=1, lev:1, sunbun=1, idx=10  //가정

   (2) select sunbun from board where lev=1 and refer=1; // sunbun이 1 or 3 or 6
       int self = -1;
       int i=0;
       while(rs.next()){
          int sunbun = rs.getInt(1);
          list.add(sunbun);
          if(sunbun== 1){
               self = i;  
          }
          i++;
       }
       if(list.size() == (self+1) ){
           int lastsunbun = list.get(self);
           (3) where refer=1 and sunbun>=lastsunbun; 
       }else{
           int selfsunbun =  list.get(self);
           int nextsunbun =  list.get(self+1);
           (3) where refer=1 and sunbun>=selfsunbun and sunbun<nextsunbun; 
       }
       
      

   
   