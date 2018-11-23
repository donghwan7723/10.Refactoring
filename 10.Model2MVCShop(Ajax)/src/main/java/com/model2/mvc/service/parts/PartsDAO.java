package com.model2.mvc.service.parts;


import java.util.Map;

import com.model2.mvc.service.domain.Parts;




public interface PartsDAO {

		// INSERT
		public void addParts(Parts parts) throws Exception ;

		// GET
		public Parts getParts(Parts parts) throws Exception;
		
}
