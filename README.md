# Selenium
Basic of selenium

                      extends                implements                   extends                 extends
		 
     SearchContext(I)--------->WebDriver(I) -----------> RemoteWebDriver(c)----->ChromiumDriver(c)----------> ChromeDriver,Fiexfor Driver etc..
                      extends
     SearchContext(I)-------->WebElement(I)
     
     -RemoteDriver Driver Extends other all drivers
     - WebDriver Contain 5 Interfaces
      WEbDriver(I): methods used for handle the browser 
     WebElement(I) : its a interface used for handling WebElements(it represent perticuler web element on web site)
     -whatever we see on web page in called web element
    -selenium have a methods using that we interact with web elements
    -Locater methods : its used to find location of perticular (web element)   element(tag) (locate the element on web page)
    --jar file collection of .class files
    -- its used to specifiey single web element
    Action methods:after finding the web element what action will be perform its another part
    Maven : Project bulid  tool (automatically configur jar file) and all project
            maven has 3 repository 
	               1 local : m2
		       2 remote : repo1.maven.com
	               3  Central : mvnrepository.com
            3 lifecycle in maven 
	      1 clean : when we run clean cycle old .class file delete
              2 Default : 7 diff phase  
	                  1 validate : check project valid or not comand-->MVN Validate
		          2 compile   :if valid porject then compile---> MVN compile
	                  3 test    : its run all test case which we writen-->MVN test
		          4 package   : it will validate,compile,test and then packageing create a jar file--->MVN package
	                  5 verify   : varify jar file-->MVN verify
		          6 install  : installed in local repo-->install
	                  7 deploy   : jar file depoly in server-->MVN deploy
	      3 Site  : prepare site doc
-----------------------------------------------------------------------------------------------------
methods :
 
 WebDriver dr = new ChromeDriver();
 
 dr.get("website url");
 
//its provide the actual title of website
 driver.getTitle();
 
// for close the browser
//its better to use quit insted of close because close have some error like(WARNING: Connection reset java.net.SocketException: Connection reset)
 driver.close();
 driver.quit();
 
// maximize window
  driver.manage().window().maximize();
  
 // capture the value of text (string)
 String a =  getText();
 String s = driver.findElement(By.xpath("//a[text()='Watchlist']")).getText();	
 System.out.println(s);

//is display (boolean)
 boolean a = driver.findElement(By.cssSelector("span.a-truncate-cut")).isDisplayed();
 System.out.println(a);
 
 
 ------------------------------------------locaters------------------------------
  

//normal Selector//

	// all methods  in BY class ,return type of method is by class object
        // all normal locater are find using only attribute value or tag name
       // its used to find (locate) the element //pass attribut into (By.) class
          
			--->pass locater(location) using By class
    1.driver.findelment(   By.id()   ).sendKeys("new mobile");
                                  
    2.driver.findElement(By.name("field-keywords")).sendKeys("dd");
  
    3.driver.findElement(By.className("a-link-normal")).click();
  
    4.locators used to identify and extract hyperlinks from HTML elements:
                     driver.findElement(By.linkText("Best Sellers")).click();//we have to pass complet text of the link text
                     driver.findElement(By.partialLinkText("best")).click(); // here we to pass some part of the link text
  
    5.Dimension link = driver.findElement(By.tagName("a")).getSize(); //is used to identify elements based on the HTML tag name. 
    
  // customized locaters//
  
              css selectors  (using id,class we can select group of element if there is not specific  id, class )
  
    1. tag and id  -----> tag#id     
  
    driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("css");
                                     --->   #   -------------->
				     tag     #    attribute value
									 
    2.tag and class----------> tag.class
	
	boolean a =	driver.findElement(By.cssSelector("span.a-truncatecut")).isDisplayed();
	System.out.println(a);                            --->      -------------->
	                                                 tag     .    attribute value
	
    3.tag and attribute------------>[attribut =value]
  
    driver.findElement(By.cssSelector("select[aria-describedby='searchDropdownDescription']")).click();
                                    ----->        ----------------------->
			        	tag                    attribut =value
									
									(tag name not complsoary)
									
    4.tag , class and attribute-------------------> tag.className[attribut="value"]
  
  
    driver.findElement(By.cssSelector("input.nav-input[placeholder='Search Amazon.in']")).sendKeys("djcnl");
                                     ---> . ------->  ---------------------------->
				    tag  . classname              attribute =value
									 
	
//Xpath selector//
	
	--its  derived from XML its a adrress of the element.
	--X-path work on a DOM(Document object model) which is got create when you browser the web page at run time 
	--X-path work on dom
	-- 2 type of x-path ::  --absolute X-path(full X-path) :: /html/body/div[1]/nav/div[1]/div[5]/ul[1]/li[3]/button
	                          never specifiy any attribute
			          its not recomnded for under devlopment project used olny when UI fix
			         its start from beging (traverse through each node till it find element)
				 absolute start from /
	                        
						    	(both same for performance)                    
							                                               
	                       -- relative X-path(partial X-path) :: //*[@id="component-id"]/div[1]/div[5]/ul[1]/li[3]/button /--> directly jump to the element
				  here we user single or multiple attribute
	                          using relative directly jump to the elements attribute	
			          
			        	relative start from //
					                creating relative x- path two types ::  1 autmomatically
							                                        2 manually(own X-path)
																	                      
    manually(own X-path)::
        1. X-path with single attribute   //tagname or * [@attribut='value'] 
        driver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']")).sendKeys("mil gaya");
  
        2. X-path with multiple attribute   //tagname or * [@attribut='value'][@id="gh-ac"]
        driver.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input'][@id='gh-ac']")).sendKeys("mil gaya");
 
     3.X-path with and or oprators //tagname or *[@class='gh-tb ui-autocomplete-input' and  @id='gh-ac' ] (both att must be correct)
                            driver.findElement(By.xpath("//a[@title='My eBay and @class='gh-eb-li-a gh-rvi-menu']")).click();
			    driver.findElement(By.xpath("//a[@title='My eBay or @class='gh-eb-li-a gh-rvi-menu']")).click();

     4. X-path with inner text(here we not used any attribute its used for link and innertext)              
         function :- text()
        //*[text()='Expand Watch List']
	driver.findElement(By.xpath("//a[text()='Watchlist']")).click();
	
    5. X-path with contains
      function:- contains()
      //img[contains(@role,'pre')]
      or
      //img[contains(text(),'pre')]
     driver.findElement(By.xpath("//img[contains(@role,'pre')]")).click();
                                                 --->   -->               
				    name of attribut  ,   value of attribute
						
			(contains and start-with used when locate dynamic web element)
						
    6. X-path with start-with 
       function:- starts-with()
      //img[starts-with(@role,'pre')]
      or
      //img[starts-with(text(),'pre')]
      driver.findElement(By.xpath("//img[starts-with(@role,'pre')]")).click();

     7. X-path with chained  (if we dont have inner text and attribut of the element then use parent of that element and write X-path)

                 its a combination of relative and absolute x-path
                //div[@id="gh-top"]/ul[2]/li[3] 
		driver.findElement(By.xpath("//div[@id='gh-top']/ul[2]/li[3]")).click();

     8. X-path Axeses :: 
                         find x-path using relationship 
			      1 parent 2 child 3 ancestor 4 descendant 5 self 6 sibilng 7 following silbilg
	                 
----------------------------------------Web_Driver AND Web_Element Methods-------------------------------------------------------------------

    1 get method -->Web_Driver
    2 browser method --> Web_Driver
    3 navigation method --> Web_Driver
    4 wait method -- > Web_Driver
    5 conditional method -->Web_Elemet
   
    
1 Web_Driver(I) Method--->  
    
    1.get method ---> 

                 (We can access these method through WebDriver(I) instance)
                 //all get method releted to web page
		 
	1 get(url) ---> open the url on the browser
                 its used to launch application URL return type is VOID
		 driver.get("https://www.mercedes-benz.com/en/");
	
	2 getTitle() ---> return title of the page
	        its used to return title of web page  retrun typr STRING
		String e = driver.getTitle();
		System.out.println(e);
		
	3 getCurrentUrl() ---> returb url of the page
	     its return URL of current Web page return type STRING
	     String as = driver.getCurrentUrl();
	     System.out.println(as);
		
	4 getPageSource() ---> return source code of page
	     its return page Source return type STRING
	     String r = driver.getPageSource();
	     System.out.println(r);
	
	5 getWindowHandle() ---->  return ID of the single Browser window
	     its return  ID of single Browser Windows  each time when we launch new browser windows the ID keep Chaning return type STRING 
             String r =  driver.getWindowHandle();
	     System.out.println(r);
	  
	6 getWindowHandles() ----> return ID's of the multiple browser window
	   its return ID of multiple Browser Windows if ther is only one windows open its provies only one ID
	   return type STRING
	   Set<String> r2=  driver.getWindowHandles();
	   System.out.println(r2);

    2 browser method ------->
                    void
	      //WeBDeriver(I) methods
              1 driver.close();//its close only one window 
              2 driver.quit(); // its close multiple window

         // for close the browser
         //its better to use quit insted of close because close have some error like(WARNING: Connection reset
         java.net.SocketException: Connection reset)

    3 navigation method--------> 
                                   void
                              --WeBDeriver(I) methods
                              -methods call from driver
                             - all method has void return type
  
      1 navigate().to()----->  
				  - the diff between get() and navigate().to in get we only pass URL in string formate
				  - in navigate().to  we pass URL in String and URL object
				  
				  driver.navigate().to("https://www.sony.co.in/homepage");
				                    --->
			             internaly calling Get method
		         
				  - URL myurel =new URL("https://www.sony.co.in/homepage");
				  - driver.navigate().to(myurel);
		                         
       2 navigate().back()--->
       3 navigate().forward()--->
		
		driver.navigate().to("\"https://www.sony.co.in/homepage\"");
		driver.navigate().to("\"https://www.apple.com/\"");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());					 
		
	4 navigate().refresh()--->
		  used for refreshthe page 
		  driver.navigate().refresh();


    5 wait method-------> 
       
                 ElementNotFoundException: when locater in inccorect
		 NoSuchElementException : because of Synchronizaion problem 
		 Default time of wait is 0
                 execution speed faster appliction or automation script faster than application respons that will cause synchronizaion problem
		
	//provide by selenium (in every wait statment still we will have chance of getting Exception if it take more time insted of specified time for that we use try catch block)
		   1 implicit wait()--->
		   its create only once at starting after creating driver
                   implcite is applicable all the statment in our automation and its alive till close the driver		
            
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		   
		 
		    2 explicit wait()--->
		        it work on  condition and time 
			its applied to specific web element
			in that in 1st consider the condition and then cosider time 
			class used for explicit------> WebDriverWait my = new WebDriverWait(driver,time);  
			        
				   WebDriver driver = new ChromeDriver();
		                   WebDriverWait dr = new WebDriverWait(driver,Duration.ofSeconds(10));
		                      --->condition specific using until()
				   dr.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/Toolsqa.jpg']")));
                                   boolean d =  driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']")).isDisplayed();
                                   System.out.println(d);
				   
				   or 
				   
				    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Declaration  
                                    WebElement w =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src='/images/Toolsqa.jpg']")));
                                     w.isDisplayed();
		
	        3 fluent wait()------->
			
		//provied by java 
		 thread.sleep(2000)
		 if web take less time to open  and we provide sleep more time the remaning time is wested or web take more time and we give sleep less time it through exception
		 every time we have to use sleep
		 it become a poor peformance
	 
  
4 WebElements(I) Methods---->

                  (access this command through WebElement(I) instance)
                 // we can access or apply the methods on web element
                 // all methods return boolean.
   
        1 isDisplayed()----->
	         method used to verify presence of a web element within the webpage.            
	         boolean a = driver.findElement(By.cssSelector("span.a-truncate-cut")).isDisplayed();
                 System.out.println(a);
	   
	2 isEnabled()--->
	           we can check  enable /disable status of the element /oprational element
	           is primarly used with button.
	          its mostly user for input boxes,dropdown ,radio button and check boxes
	           Boolean en = driver.findElement(By.className("brandhub-relaunch-button brandhub-relaunch-button--white brandhub-relaunch-button--size-m brandhub-search__button-right")).isEnabled();			
	           System.out.println(en);
			   
	3 isSelected() ----->
	         we can use to check the element is selected or not
		 apply for radio button ,checkbox
		 Boolean e1 = driver.findElement(By.className("brandhub-relaunch-button brandhub-relaunch-button--white brandhub-relaunch-button--size-m brandhub-search__button-right")).isSelected();
		System.out.println(e1);

        4 findelement()----> 
                    WebElement Return type
                  - it gives you a reference to that element on the web page, allowing you to interact with 
		  - it using various methods provided by the WebElement interface.
    
                     - it returns all the  elements matching to the  x-path 
		      -  return type is list
	              -if there is no element found return empity list
                    - List<WebElement> findElement(By by) return type LIST<WebElement>
		       List<WebElement> r =obj.findElements(By.className("firstname"));
	                                &
	               - it return the single web element retutn type WebElement
		       - it return 1 st occurance
	                - if there is no element found it will through no such element exception      
                          
		      -  WebElement s = obj.findElement(By.className("first"));
	
         5 submit()--->
	                  void
		         - its click on submit or ok button here the condition is that it's only work with form tag
                         -we can write any locater of form for submit()
		 obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']")).sendKeys("vivek");
		obj.findElement(By.xpath("//input[@class='form-control form-control input-block js-password-field']")).sendKeys("ram");
		obj.findElement(By.xpath("//input[@class='form-control form-control input-block js-password-field']")).submit(); 
                                                or
		obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']")).sendKeys("vivek");
		obj.findElement(By.xpath("//input[@class='form-control form-control input-block js-password-field']")).sendKeys("ram");
		obj.findElement(By.xpath("//input[@class='btn btn-primary btn-block js-sign-in-button']")).click(); 				
		
		   

          6 sendKey()---->
	                      void
	                    -send charcter sequance in textbox
		            - we can also pass Keys. in send key 
	                   driver.findElement(By.cssSelector("input[class='query-input__form-input']")).sendKeys("i ot it ");
		    - Keys--->
                              keys enum provied by selenium we driver with the help of that we can pass the non text key into your web component
		   ( IMP )obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']")).sendKeys("vivek",Keys.ENTER,"ram",Keys.ENTER);
     
          7 clear()--->
	            void clear the text writen into a text box
                      
                      WebElement e = 	obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
                	e.sendKeys("vivek");
	                e.clear();
		 
          8  getTagname()-->
	                    return the tag or element name 
	                    WebElement e = obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
	                     System.out.println(e.getTagName());

          9 getAttribute()-->
	                   it return the attribute value   
	                   WebElement e = obj.findElement(By.xpath("//input[@class='form-control input-block js-login-field']"));
	                   System.out.println(e.getAttribute("class"));
		    
          10 gettext()----> 
	                    its return the inner text
	                   String r =obj.findElement(By.xpath("//a[@class=\"label-link position-absolute top-0 right-0\"]")).getText();
		           System.out.println(r);
          
          11 getShadowRoot()--->
	                          SearchContext
			   (Find all elements within the current context using the given mechanism.)
	                        ShadowDom element : shadowDom allow us to create a subtree inside dom element
			        without changing the excting layout , new webelement  introduce  with its  own style
	                        shadowRoot(opne) then we handle the element
                          obj.findElement(By.xpath("//a[@class=\"label-link position-absolute top-0 right-0\"]")).getShadowRoot().findElement(By.id("root")).getText();
			  
          12 getLocation()---> 
	                      point
	                      return the location of element 
		       WebElement f =obj.findElement(By.xpath((("//a[@class='label-link position-absolute top-0 right-0']"))));
		       System.out.println(f.getLocation());
	                                                            or
			Point location = sigin.getLocation();
		        System.out.println("Location of X :"+ location.getX()+ "," +"Location of Y :" +location.getY());				     
 
          13 getcssvalue()--->  
	                   string
		           also get font,width
	                  color -->textcolor
		          background-color-->bg color of text
	                      obj.findElement(By.xpath(("//input[@class=\"btn btn-primary btn-block js-sign-in-button\"]"))).getCssValue("color");
		       
	  14 getSize()---> 
                         Dimantaion
			  return element width and hight
                          System.out.println(obj.findElement(By.xpath((("//a[@class='label-link position-absolute top-0 right-0']")))).getSize());
          15 getRect()-->
	               return element location and size
		
------------------------------------ERRORS---------------------------------------------------
                                       
					//how to resolve error
    unsupported class version : using maven clean, it will clear old .class file  after that for genrating new .class file click on (generate sources)
    Element not interactable :  
----------------------------------------Qustions--------------------------------------
     
     handle shadowroot 
    how to get color of web element  : getcssvalue()







  
