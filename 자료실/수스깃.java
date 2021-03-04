<<1>> IDE를 사용하지 않은 Git

[1] 마스터 ( main ) 

	(1) 이메일(khs4git1@nate.com) 생성 

	(2) 회원가입( Sign in -> 이메일 검증 ) 
		https://github.com/ 

	(3) Repository 생성 ( 오른쪽상단의 + 를 클릭 ) 
		ex) JavaCode

	(4) GitHubDesktopSetup.exe 설치 및 실행 

	(5) GitHub Desktop 계정 변경 
		File -> Options -> Sign out 
		-> Sign in -> Continue with browser -> Authorize desktop 

	(6) 'Clone' Repository
		1) 로컬디렉토리 생성 
		   ex) C:\SOO\Git\JavaCode

		2) 왼쪽상단 Current repository -> add 
		   ex) 순서이미지/01_방법1(Clone Repository).png 
			   순서이미지/01_방법2(Clone Repository).png 

	(7) 로컬 Repository에 자료 붙여넣기 

	(8) GitHub Desktop 
		Changes탭 -> (Summary+Description) 
		-> Commit to main 버튼 -> 'Push origin'

[2] 브랜치 ( branch ) 
    (1) 원격지 생성 
	    main -> Find or create a branch -> branch1
	    ex) https://github.com/khs4git1/CatchMind

    (2) 브랜치 동기화 
	    1) GitHub Desktop 상단에 Fetch origin 클릭 
	    2) GitHub Desktop 상단에 Current branch 클릭 
		   -> 생성된 브랜치가 보임 

    (3) 브런치로 작업
	    1) GitHub Desktop 상단에 Current branch -> branch1 
		2) 로컬 CatchMind에 변경(추가/수정/삭제)

    (4) GitHub Desktop 상단에 Current branch 변경
	    로컬 CatchMind의 내용이 해당 브런치에 맞게 변경  

    (5) 원격지에 적용 ( Create Pull Request ) 
	    branch1 의 작업 내용을 main에게 적용 -> Comfirm 버튼 

    (6) 로컬에 적용 ( 원격지의 변경된 main내용을 로컬에 적용 )
	    1) Fetch origin -> Pull origin 버튼 
	    2) GitHub Desktop 상단에 Current branch 변경하면 
		   '원격지의 main'과 동기화 됨 확인할 수 있음 

    (7) 삭제 
	    main -> View all branches -> 휴지통 아이콘 
       
    
<<2>> IDE를 사용하는 Git    