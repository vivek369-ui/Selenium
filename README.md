# Selenium
Basic of selenium



                 extends                implements                   extends                 extends
SearchContext(I)--------->WebDriver(I) -----------> RemoteWebDriver(c)---->ChromiumDriver(c)----------> ChromeDriver,Fiexfor Driver etc..

-whatever we see on web page in called web element
-selenium have a methods using that we interact with web elements
-Locater methods : its used to find location of perticular (web element)   element(tag) (locate the element on web page)
 -- its used to specifiey single wen element
Action methods:after finding the web element what action will be perform its another part


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
 //locaters//    (all normal locater are find using only attribute)

***normal Selector
 // its used to find (locate) the element //pass attribut into (By.) class
              | 
			        |       --->pass locater(location) using By class
 1.driver.findelment(   By.id()   ).sendKeys("new mobile");
                                  --------------------->
                                  write text into the box

  2.driver.findElement(By.name("field-keywords")).sendKeys("dd");
  
  3.//locators used to identify and extract hyperlinks from HTML elements:
  driver.findElement(By.linkText("Best Sellers")).click();//we have to pass complet text of the link text
  driver.findElement(By.partialLinkText("best")).click(); // here we to pass some part of the link text
  
  4.Dimension link =	driver.findElement(By.tagName("a")).getSize(); //is used to identify elements based on the HTML tag name. 
  
  5.driver.findElement(By.className("a-link-normal")).click();
  
  // customized locaters//
  
  ***css selectors  (using id,class we can select group of element if there is not specific  id, class )
  
 1. tag and id  -----> tag#id     
  
  driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("css");
                                     --->   #   -------------->
									                  tag         attribute value
									 
    2.tag and class----------> tag.class
	
	boolean a =	driver.findElement(By.cssSelector("span.a-truncatecut")).isDisplayed();
	System.out.println(a);                           --->      -------------->
	                                                 tag     .    attribute value
	
   3.tag and attribute------------>[attribut =value]
  
  driver.findElement(By.cssSelector("select[aria-describedby='searchDropdownDescription']")).click();
                                    ----->        ----------------------->
								                   	tag                    attribut =value
									
									tag name not complsoary
									
  4.tag , class and attribute-------------------> tag.className[attribut="value"]
  
  
  driver.findElement(By.cssSelector("input.nav-input[placeholder='Search Amazon.in']")).sendKeys("djcnl");
                                     ---> . ------->  ---------------------------->
									                   tag  . classname              attribute =value
									 
	
	***Xpath selector
	
	--its  derived from XML its a adrress of the element.
	--X-path work on a DOM(Document object model) which is got create when you browser the web page at run time 
	--X-path work on dom
	-- 2 type of x-path ::  --absolute X-path(full X-path) :: /html/body/div[1]/nav/div[1]/div[5]/ul[1]/li[3]/button
	                          never specifiy any attribute
							              its start from beging (traverse through each node till it find element)
							               absolute start from /
	                        
						    	both same for performance
							
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
                             //tagname or *[@class='gh-tb ui-autocomplete-input' or  @id='gh-ac' ] (one must be correct)

driver.findElement(By.xpath("//a[@title='My eBay and @class='gh-eb-li-a gh-rvi-menu']")).click();

4. X-path with inner text(here we not used any attribute its used for link and innertext)
               
method :- text()
//*[text()='Expand Watch List']
	driver.findElement(By.xpath("//a[text()='Watchlist']")).click();
	
5. X-path with contains
   
 method:- contains()
 //img[contains(@role,'pre')]
  driver.findElement(By.xpath("//img[contains(@role,'pre')]")).click();
                                              --->   -->               
								                 name of attribut  ,   value of attribute
						
						(contains and start-with used when locate dynamic web element)
						
6. X-path with start-with 

methods:- starts-with()
//img[starts-with(@role,'pre')]
driver.findElement(By.xpath("//img[starts-with(@role,'pre')]")).click();

7. X-path with chained  (if we dont have inner text and attribut of the element then use parent of that element and write X-path)

its a combination of relative and absolute x-path

    //div[@id="gh-top"]/ul[2]/li[3] 
		driver.findElement(By.xpath("//div[@id='gh-top']/ul[2]/li[3]")).click();
