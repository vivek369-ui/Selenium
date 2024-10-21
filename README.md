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
                   its only work on find element and findelements only(its only wait until (load)find the element once element find then move forward it not care about other oprations)
		   its create only once at starting after creating driver
                   implcite is applicable all the statment in our automation and its alive till close the driver		
            
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		   
		 
		    2 explicit wait()--->
                       its only have a constructor
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
	              -if there is no element found return empty list
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
			         ShadowRoot (user-agent) you can not access a shadowdom created by browser to display a control
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

  ---------------------------------------------------------Drop_Down-----------------------------------------
                       
              1 single select drop down  1  Bootstrap Drop Down
	      2 multi select drop down   2  hidden Drop Down
               - select class used to handle drop down list Select b = new Select(element);
	       - select class only used when the dropdown list created using select tag
               - for selecting element we have 3 option
               - using click regular method handle drop down when select tag not present 
	       - other than select tag that drop down are BootStrap and hidden drop down
           1 selectbyindex()---->void
	                       Select b = new Select(element);
		               b.selectByIndex(3);
	   2 selectbyvalue()--->void
                              if value  attribut not in tag we cant use this method
                             	b.selectByValue("search-alias=amazon-devices");
          3 selectByVisibleText()----->void
	                              select by visible text pass the text which is visibe in dropdown
	                         b.selectByVisibleText("indes");
	  4 isMultiple()------->boolean
                                when dropdown list is multi select type it return true otherwise return false 
				  System.out.println(b.isMultiple());
	 5 deselectAll()---->void
                                   d.deselectAll();
				   
	 6 deselectByIndex()---> void
		b.deselectByIndex(2);
  
	 7 deselectByValue()--->void
		b.deselectByValue("search-alias=amazon-devices");
  
	8 deselectvisibleText()--->void	
		b.deselectByVisibleText("indes");
  
        9 getAllSelectedOptions()---> List<WebElement>
	                  its return no. of selected options from drop down
	       		  List<WebElement> f = b.getAllSelectedOptions();
	    
	10 getOptions()--->List<WebElement>
                     its return the all  no. of option from  dropdown list 
                              List<WebElement> d =b.getOptions();
	                      System.out.println(d.size());
		        -------------------------------Handling_Hiden_DropDownList------------------------
	  
------------------------------------Actions/Mouse and KeyBorad Opration----------------------------------------------------------------------
                       
			-predefine class provide by selenium through that we perfom opration
                        - 2 Action is available 1 Actions is a class and  2 Action is interface
                        - using that we can also performe KeyBoard actions
                              Actions ac = new Actions(Driver)
		Mouse :	
  
           moveToElement(web element) ------->Mouse Hover 
	                    WebElement linkElement = obj.findElement(By.xpath("(//a[@data-toggle=\"dropdown\"])[1]")); 
		            Actions actions = new Actions(obj);
		            actions.moveToElement(linkElement).build().perform()
	                                                       ------------------> it will write every time when use Action class method and method end with build and perform
                                                            (build:-  will create action , perform:-  will complit the action)
                         - if we write (perform) directly  it internaly build the action 
			 
           contextClick(web elemen) ----------->  Right Click 
                         WebElement elemen = obj.findElement(By.xpath("//*[@class='context-menu-one btn btn-neutral']"));
		         Actions action = new Actions(obj);
		         action.contextClick(elemen).build().perform();
   
            doubleClick(elemn)----> Double Click

				       WebElement elemn = obj.findElement(By.xpath("//*[@id='clickable']"));
		                       Actions action = new Actions(obj);
		                       action.doubleClick(elemn).build().perform();
			 
	    dragAndDrop(drag, drop)  -------->  Drag and Drop
                                           - location of drag and drop befor performing the opration
					   
					    Actions action = new Actions(obj);
		WebElement drag = obj.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop =obj.findElement(By.xpath("//*[@id='droppable']"));
		action.dragAndDrop(drag, drop).build().perform();


             KeyBorad :
              action.KeyUp--> unpress the key       
              action.KeyDown-->pressing the key        ------>send the character A to Z use sendkey
                           a.keyDown(Keys.CONTROL ).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
			  -last key always reles the first
          on.click(ele)---> 
	                   click method present both web element class and Actiond class diff is that 
		           in web element not accept any parameter and in Actions it accept parameter
---------------------------------JavascriptExecutor-------------------------------------
                         
			 JavascriptExecutor (I)
	We can execute javaScript Statment using JavascriptExecutor.
        when method like(click(),sendkey())..etc not able to execute js internally its  throw exception
	- for overcome that issue we can directly execute js method  through executeScript("pass javascript statment") from JavascriptExecutor
          - any js statment execute through   executescript()
	
         executescript()--->
                                   use of this method we execute js directly
				
	                             WebElement inputbox=driver.findElement(By.xpath("(//*[@type='text'])[1]"));
                                 	JavascriptExecutor js = (JavascriptExecutor) driver;
				                                   ---->Set the value
	                          js.executeScript("arguments[0].setAttribute('value','vick')", inputbox);
			                            -----> store the web element(inputbox)
                                   js.executeScript("arguments[0].click",button);

				     scrollBar:
                                     scrollBar belong to browser not to application
				     3 aprroch using pixel no. or scroll the page till element display or till end of the page 
	  1 scroll down page by pixel no.-->
	            scrollBy(0,3000) -->             --->pixel
	          js.executeScript("window.scrollBy(0,3000)", "");//scroll
		  System.out.println(js.executeScript("return window.pageYOffset",""));//return pixel value

	  2 scroll the page till element display -->
                               WebElement jd = driver.findElement(By.xpath("(//*[@href='#popupDemo'])[16]"));
		                js.executeScript("arguments[0].scrollIntoView()",jd);
		                System.out.println(js.executeScript("return window.pageYOffset",""));//5535
		  
          3 till end of the page --->   .scrollBy
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset",""));
  
         4 scrolling up initial position--->
	                                 .scrollBy             ---(-)
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

          5 maximixe and minimize in %
	          js.executeScript("document.body.style.zoom='30%'");
------------------------------------------ScreenShort-------------------------------------------------------

                     TakeScreenShort(I)
                                              -->this method capture the screenshort
                 - File datafile = shot.getScreenshotAs(OutputType.FILE);
		                                                    ----> take screenshort in the form of file
			   -->copy the screenshort file to  our won location
		 - File targetfile = new File(System.getProperty("user.dir")+"\\Screenshort\\firstphoto.png");
                                               ----------------------------> it will return current location   
                 -  datafile.renameTo(targetfile);
		     ---->  copy sourece file to our won location 
		             
------------------------------------------Options class---------------------------------------------
                            
			       (refer web site : https://www.tutorialspoint.com/selenium/selenium_webdriver_chrome_options.htm)
           -its a predifine class for each browser having option class like ChromeOptions or Edgeoptions etc... we can use this option class
	    for control the browser  specific setting
         1 addArguments()--> 
	          1 headless:-
	             ChromeOptions option = new ChromeOptions();
		     option.addArguments("--headless"); // setting of headless testing
                                           -------> its perform in dev-ops envirment
		     WebDriver driver = new ChromeDriver(option);
       
                  2 run the test in incognito mode 
                        ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
                                             
		   options.addArguments("--start-maximized");
                                          (is called flag)
                                --disable-client-side-phishing-detection: Disables client-side phishing detection
				--disable-component-extensions-with-background-pages: Disable some built-in extensions that aren't affected by --disable-extensions
				--disable-default-apps: Disable installation of default apps
				--disable-extensions: Disable all chrome extensions
				--disable-features=InterestFeedContentSuggestions: Disables the Discover feed on NTP
				--disable-features=Translate: Disables Chrome translation, both the manual option and the popup prompt when a page with differing language is detected.
				--hide-scrollbars: Hide scrollbars from screenshots.
				--mute-audio: Mute any audio
				--no-default-browser-check: Disable the default browser check, do not prompt to set it as such
				--no-first-run: Skip first run wizards
				--ash-no-nudges: Avoids blue bubble "user education" nudges (eg., "… give your browser a new look", Memory Saver)
				--disable-search-engine-choice-screen: Disable the 2023+ search engine choice screen
				--propagate-iph-for-testing: Specifies which in-product help (IPH) features are allowed. If no arguments are provided, then all IPH features are disabled.
                                --headless: Runs Chrome in headless mode (no UI).
				--no-sandbox: Disables the sandboxing feature (is a security technique that involves running code or applications in an isolated environment to test and 
                                    analyze them for threats).
				--disable-gpu: Disables GPU hardware acceleration (often used with --headless).
				--start-maximized: Opens Chrome in maximized mode.
				--incognito: Opens Chrome in incognito mode.
				--disable-extensions: Disables all Chrome extensions.
				--disable-popup-blocking: Disables the popup blocking feature.
				--disable-infobars: Disables the 'Chrome is being controlled by automated test software' infobar.
				--disable-dev-shm-usage: Disables the use of /dev/shm (shared memory) which can be useful in Docker environments.
				--remote-debugging-port=<port>: Enables remote debugging on the specified port.
				--user-data-dir=<path>: Specifies the user data directory for Chrome profiles.
				Privacy and Security Flags
				--disable-client-side-phishing-detection: Disables client-side phishing detection.
				--disable-popup-blocking: Disables the blocking of pop-ups.
				--disable-web-security: Disables web security, including CORS. This flag is often used for testing but should be used with caution.
				--disable-features=<feature1>,<feature2>: Disables specific Chrome features (e.g., --disable-features=NetworkService,Sync).
				Performance and Testing Flags
				--enable-automation: Enables automation mode.
				--disable-background-timer-throttling: Disables background timer throttling.
				--disable-renderer-backgrounding: Disables backgrounding of renderer processes.
				--disable-accelerated-2d-canvas: Disables accelerated 2D canvas.
				UI and Display Flags
				--disable-notifications: Disables notifications.
				--disable-translate: Disables automatic translation of web pages.
				--kiosk: Opens Chrome in kiosk mode (full screen).
				Experimental Features
				--enable-experimental-web-platform-features: Enables experimental web platform features.
				--enable-features=<feature1>,<feature2>: Enables specific Chrome features (e.g., --enable-features=NetworkService,Sync).
      
        2 setAcceptInsecureCerts(true)--> 
	        3 SSL handling:- 
	            accept the ssl certificate
	          ChromeOptions option = new ChromeOptions();
		  option.setAcceptInsecureCerts(true);//accept ssl certificates from the web pages
   
         3 setExperimentalOption("excludeSwithes",new String[] {"enable-automation"})--->
                   4  Disable Automated messange on screen when selenium  open browser
                       ChromeOptions option = new ChromeOptions();
		       option.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"}); 

         4 option.addExtensions(fi)--->
	            add external file in browser
                        ChromeOptions option = new ChromeOptions();
			File fi =  new File("Block.origin.crx");
			option.addExtensions(fi); 
			WebDriver driver = new ChromeDriver(option);	

--------------------------------------BrokenLink-----------------------------------

	      - whatever link  1st we check it have href value attribute because this is url which  we send to the server.
              - response Status code imp to find the link is broken or not if the status code is >=400 mens its broken link  or <= 400 its not broken link

--------------------------------TestNG--------------------------------------------------------------
 
     - TestNG provides you full control over the test cases and the execution of the test cases. Due to this reason, TestNG is also known as a testing framework
     - testNG basically unit testing tool orginize test case and test suites, execute test case , genrating reposrt,prioritize,parameterization,parallel tesing and many feature
     - to achive some feature we have to add some tag  manually in XML file 
     - insted of use main method we use Annotation in TestNG
     
      1 XML :
		     - execute multiple  test case at a one Suite testNG XML file
		     - genrate reports
		     - Capable of triggering parallel execution.
		     - The file helps organize test cases in a structured manner, making it easier to understand the code.
		     - Users can define which test classes and methods to run, test parameters, and test groups
		     - The file makes it easy to create multiple test cases simultaneously, using TestNG Annotations 
                     - the thread count allows for parallel execution of test methods or classes, not necessarily limiting one thread per class. If you have more methods or classes than 
                    
    thread-count="5" - parallel="methods": If you have multiple test methods in one or more classes, TestNG will execute up to 5 methods concurrently. If a single class has multiple 
                                            methods, they can all potentially be run in parallel, using the available threads.
                        parallel="classes": If you set this, TestNG will run up to 5 classes concurrently, meaning that each class can get one thread, but if you have more than 5 
                                            classes, only 5 will run at the same time.
                     - the thread count, the remaining ones will wait until a thread becomes available.
                     - If you want to ensure a single thread per class, you'd typically set thread-count equal to the number of classes you have in your test suite.
		     
		     - 2 way to genrate xml file(suite) :
		         1 manually 2 automatically genrated xml
		
		         2 automatically genrated : (using Convert to testNG)
					   testng.xml 
			           <suite name="Suite">
	                            
			                  ----> its optional mostly used when do parallel testing 
				   <test thread-count="5" name="Test">
				    <classes>
			                       -----------> here we write the name of class
				      <class name="testNG.NewTest"/>
				    </classes>
				  </test> <!-- Test -->
				</suite> <!-- Suite -->
		  
			      - report of testing in folder(test-output) :
			         emailable-report.html
				 index.html
		 
		        1 manually :
		                 click on package-->new-->File-->myfile.xml(file name)-->finish-->
		   
				  <?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
				<suite name="myFirstSuite">
					<test name="testcase">
						<classes>
							<class name="testNG.TestCase">
                                                        <methods>
							 ---> exclude used of ignore the test case method
                                                        <exclude name="test2"></exclude>
			                                <include name="test3"></include>
				                         --> include used to run that particuler test case method
				                       </methods>
                                                         </class>
							<class name="testNG.NewTest"></class>
						</classes>
					</test>
				
				</suite>
                  


    
    2 Annotion :
                    (@BeforeMethod , @AfterMethod , @BeforeClass , @AfterClass , @BeforeTest , @AfterTest , @BefoteSuite , @AfterSuite)
		    
	   - annotation is designed to run cleanup code after each test method in the class, and it is automatically invoked by TestNG without needing to be specified in the XML	             - These methods are automatically called by TestNG based on their respective annotations, and you don't need to specify them in the XML file.
    
           1.  @BeforeMethod& @AfterMethod--->
	      annotations are specifically designed to execute methods before and after each test method in the class. This means that if you have multiple test methods in the same 
              class, the methods annotated with @BeforeMethod and @AfterMethod will run for each test method execution.
	      
	   2. @BeforeClass , @AfterClass--->
                          Runs once before any test methods in the class.
                          Runs once after all test methods in the class.

			   
           3.  @BeforeTest , @AfterTest--->
	                         - its releted to xml <test>
			        - test is collection of classes,  run only once before and after
	                         (In TestNG, a test is a collection of test classes defined in the XML file as a single `<test>` element, which groups multiple `<class>` elements 
                                  representing the individual test classes to be executed together.)
	                         -@BeforeTest: Runs before the first test method annotated with @Test. For example, in smoke testing frameworks, @BeforeTest can be used to set up 
                                 initial data before running other test methods.
                                 @AfterTest: Runs after all test methods annotated with @Test have completed execution.
				 
	   4. @BefoteSuite , @AfterSuite--->
                               -its execute only once before any suit and after any suit 
			       -@BeforeSuite: It will run only once, before all tests in the suite are executed. @AfterSuite: A method with this annotation will run once after the 
                                 execution of all tests in the suite is complete.
	   5.@Ignore --> 
                         its used for ignore the test case
	   1  @Test : 
		     - NG execute test case base on Alphabetical order for controling the execution of test case we have to set priority using  @Test(priority=1)
		     - if multiple method have same priority then it again cosider based on Alphabetical order
		     - if we not mention any Annotation to method, that perticular method not executed other methods run properly
		     - defalut priority of test method is 0 (if we provied priority to  methods and one method not having priority)
                                14. @Test(enabled = false)
				Purpose: Temporarily disables a test method.
				Usage: Useful during development or debugging to skip tests without removing the code.
				15. @Test(priority = x)
				Purpose: Assigns a priority level to test methods.
				Usage: Ensures tests run in a specific order, which can be crucial for tests that depend on the results of others.
				16. @Test(dependsOnMethods = "methodName")
				Purpose: Establishes a dependency between test methods.
				Usage: Ensures that certain tests only run if their dependencies have passed, which helps in managing test execution order.
				17. @Test(groups = {"group1"})
				Purpose: Categorizes test methods into groups.
				Usage: Facilitates running specific groups of tests, which is helpful in large test suites for targeted testing.
                                18. @Test(invocationCount=3)
				    NO. of time   test case repeate. if the count is 0 the test case will be ignored.         
	                        19. @Test(invocationTimeOut=33) 
			                with in given time test case must be execute else test case fail
		                        default 0.
			         --> @Test(invocationCount=3 ,invocationTimeOut=33)-->  invocationCount with invocationTimeOut
	                        20.  @Test(expectedExceptions=Exception.class)
			                Manualy provide exception 
		                21.  @Test(singleThreaded=true) 
		                        return type boolean, if set it true then only one thread run test case is calles single thread
			                its write on class level only single Thread run all tests 
                                22.   @Test(description="imp") 
			                  IMP details about test case

                                23.  @Test(dependsOnMethods="test9")  -   @Test(dependsOnMethods={"test9","test2"})
				           execution of  that method depend on the other method if previes method get error then depended method skip  the execution
	                                   is called hard Dependency
	                                   we can add multiple test methods for dependency
				24.  @Test(alwaysRun=true) 
                                             -  defalut false
                                             - in any situation  test case will be run.
					      - @Test(dependsOnMethods="test9" , alwaysRun=true)--> its create soft dependency
					      - if any dependency failes its not effect on  method when we add alwasRun 
	                        25.   @Test(groups="") 
			                  <groups>
						<run>
						<include name="smoke"></include>
						</run>
					</groups>
                                         it is used to run test case in group with help of <groups> tag and annotation
                                        - always when we need to run tests in a group creat the copy of master xml and performe grouping opration there 
				26.   @Test(dependsOnGroups="")
                                           - one group not depend on one test case 
                                           - one test case depend on group 

                            IMP 27. parametrization @Parameters :
			                             <parameter name="x" value="1000"></parameter>
	                                            <parameter name="y" value="all good"></parameter>
					                @Parameters({"x","y"})
							@Test()
							public void test2(int x , String y) {
								System.out.println(+x+"\t"+y);}  //1000 , all good                                     
					       - the execution of para only through XML
	                                       - para tag just helps to define a value
					       -@Parameters() annotaion used to set the para value for Test method
					       -To define one or more parameters that can be injected into the test method during execution.
	    
	                        28. @DataProvider : 
			               @DataProvider is used to provide parameters to a test. If you provide the data provider to a test, the test will be run taking a
		                         different set of  values each time. This is useful for a scenario
                                            like where you want to login to a site with a different set of username and password each time.
			               Data driven tesing: huge amount of data itrativly supply to the test case to check its behaver for individual data set 
	                               -provide data to the Test method
							@DataProvider(name="pincode")
						  public Object[][] provideData() {
							  Object[][] pincode= {{401203},{203401}}; 
					                  return pincode;}
		                                        @Test(dataProvider="pincode")
							public void run(int pincode)
							{System.out.println(pincode);}
				        -we can also pass method name as a dataProvider in Test method  
	                                - use extends or use dataProviderClass
				        --> @Test(dataProvider="provideData" ,dataProviderClass =DataProvider.class)
                                          
-----------------------------------------------Crossbrowser And Parallel--------------------------------------------------------------------



				    
------------------------------------------------ Assertion TestNG------------------------------------
      
      -class 
     - when we want to use validation in method we use assertion
     -only Assertion can make our test case pass or fail
     - 2 type of Assersion Hard assertion soft assersion

     Hard Assert :
        - a type of assertion that immediately stops the execution of a test method if an assertion fails. When a hard assertion fails, it: Throws an Assertion Exception, Marks the 
          method as failed, and Aborts the remaining statements inside the method
        - Assert class for hard Assertion
	- all method are static in Assert class
             Assertion hardAssert = new Assertion();
	     
      1. Assert.assertEquals(name, name3);--->Boolean
                 is a method that takes a minimum of 2 arguments and compares actual results with expected results. If both match, the assertion is passed, and the test case is marked 
                 as passed. assertEquals() can compare Strings, Integers, Doubles, and many more variables
		 
      2. Assert.assertNotEquals("vivek", "aara");-->
              is a method that does the opposite of the assertEquals() method. In this case, the method compares the actual and expected result. But if the assertion condition is met if 
              the two are not identical. The test case is marked as passed if actual and expected results are not the same.
	      
     3. assertTrue(true);--->
              This Assertion verifies the Boolean value returned by the condition. If the Boolean value is true, then the assertion passes the test case.

     4. AssertFalse(false);---->
              This method works the opposite of assertTrue(). The Assertion verifies the Boolean value returned by the condition. If the Boolean value is false, the assertion 
              passes the test case.
     5. Assert.fail();-->
                  This method fail method directly

     6. Assert.assertNull(s);-->
              Verifies if an object contains a null value
              method means "a passed parameter must be null": if it is not null then the test case fails.
	      We use Assert.assertNull() to check that the element variable is null, meaning the element does not exist on the page.

     7. Assert.assertNotNull(s);--->
             If the object is not null, the method throws an 
             method means "a passed parameter must not be null": if it is null then the test case fails.


        -In a hard assertion, when the assertion fails, it terminates or aborts the test. If the tester does not want to terminate the script, they cannot use hard assertions. To 
        -overcome this, one can use soft assertions.

     SoftAssert : 
         -Soft asserts are the asserts which continue the execution even after the Assert condition fails
	 -method are not static 
  
                             Extends            Impliment
                  SoftAssert---------> Assertion------->IAssertLifecycle(I)
                  SoftAssert class used for SoftAssertion
		  Methods are not static in SoftAssert for that reason we have to create Obj of SoftAssert class
                   SoftAssert a = new SoftAssert();
	- all hard Assertion method used in SoftAssert 
 
       1. a.AssertAll()-->
           - After all the failed assertions are collected, the assertAll() method is called to throw all the exceptions and mark the test as failed.
           - When a condition fails, a soft assertion continues with the next statement in the test case instead of throwing an exception immediately. This allows the test execution 
              to  continue even if some conditions fail.
	   - A soft assert allows the test to continue running even if an assertion fails. It collects all failures and reports them at the end.

  --------------------------ADD External Excel data into program--------------------------------------------- 

	 Apache POI : 
                     is an open-source Java library used to read, write, create, and modify Microsoft Office files like Excel, Word, and PowerPoint
	  Dependancy needed :  Apache POI Common ,  Apache POI API Based On OPC and OOXML Schemas , Apache Commons IO
  
                impliment
     Workbook(I)----------> XSSFWorkbook(c) --> High level representation of a SpreadsheetML workbook
      Sheet(I)  ----------> XSSFSheet (c) ---> Sheets are the central structures within a workbook, and are where a user does most of his spreadsheet work
      ROW(I)    ----------> XSSFRow(c) --> Row are the central structures within a Sheet, 
                 implements                       extends
      Cell(I)   ------------>  CellBase(Abstract)----------> XSSFCell(C final)--> Cell are the central structures within a Row

       DataFormatter formatter = new DataFormatter(); : l
       This class is part of the Apache POI library. It helps format the data retrieved from Excel cells,
       ensuring that it is presented as a string in a user-friendly way.
       This is an instance of the DataFormatter class that you can use to format cell values
                 DataFormatter formatter = new DataFormatter();
		String name = "C:\\Users\\admin\\Desktop\\pincode.xlsx";
		FileInputStream file = new FileInputStream(name);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet data = book.getSheet("Sheet1");
		XSSFCell cell = data.getRow(8).getCell(1);
		String info = formatter.formatCellValue(cell);
		System.out.println(info);
                      
    
------------------------------------ERRORS---------------------------------------------------
                                       
					//how to resolve error
    unsupported class version : using maven clean, it will clear old .class file  after that for genrating new .class file click on (generate sources)
    Element not interactable :  
    Element interceptedException : when method like(click())..etc not able to execute js internally its  throw exception
----------------------------------------Qustions--------------------------------------
     
     handle shadowroot 
    how to get color of web element  : getcssvalue()
    any 5 execption in selenum
     methdo in select class
    class not found error means jar not available   





  
