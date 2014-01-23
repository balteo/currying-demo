package org.scala.currying

import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CurryingDemoTest extends Specification {
	"Hello world String" should {
	  "contain 11 characters" in {
	    "Hello world" must have size(11)    
	  }
	} 
}