(1) HTML 문서
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

(3) DOM 노드 예 (node의 type, name, value)
	1) div(엘리먼트노드) : Node.ELEMENT_NODE, "div", null 
	2) one(텍스트노드) : Node.TEXT_NODE, "#text", "one"
	3) id(속성노드) : Node.ATTRIBUTE_NODE, "id", "divId" 

(4) Node 핸들링 속성 
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

(5) Node 핸들링 메소드 
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