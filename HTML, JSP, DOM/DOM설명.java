(1) HTML ����
   <html>
	   <head>
		  <title>DOM</title>
	   </head>
	   <body>
		  <div id="divId">
			 one
			 <em>two</em>
			 three
		  </div>
	   </body>
   </html>

(2) DOM Tree
			  HTML 
		   |       | 
	    HEAD       BODY 
		|            |
	   TITLE        DIV (id="divId")
		|            | 
	  "DOM"    "one" EM "three"
					 |
					"two"

(3) DOM ��� �� (node�� type, name, value)
	1) div(������Ʈ���) : Node.ELEMENT_NODE, "div", null 
	2) one(�ؽ�Ʈ���) : Node.TEXT_NODE, "#text", "one"
	3) id(�Ӽ����) : Node.ATTRIBUTE_NODE, "id", "divId" 

(4) Node �ڵ鸵 �Ӽ� 
    1) nodeType
	2) nodeName
	3) nodeValue
	4) firstChild
	5) lastChild
	6) attributes
	7) nextSibling
	8) previousSibling
	9) parentNode
	10) childNodes
    11) documentElement 


	 ex) d1.html 

(5) Node �ڵ鸵 �޼ҵ� 
    1) createTextNode()
	2) createElement()
	3) createAttribute()
	    cf) attrFont.value = "color:red"
	4) setAttributeNode()
	5) appendChild()
	6) insertBefore()
	7) replaceChild()
	8) removeChild()



     ex) d2~.html 