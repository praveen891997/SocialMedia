 package com.cg.socialmedia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:myProperties.properties")
public class Myproperties {
	Log log;
	
	
	
	
	public Log getLog() {
		return log;
	}


	public void setLog(Log log) {
		this.log = log;
	}


	public static class Log
	{
		String info;

		String localhost;
		String success;
	


	
		String noresult;
		String noelection;
		String notfound;
		
		String start;
		String exception;
		
		
		
		String found;
		String noElection;
		String noResult;
		String notFound;
		String view ;
		String Mandatory;
		String accepted;
		String rejected;
		String delete;
		String noCandidate;
		String pending;
		String reject;
		String fail;
		String pass;
		String unsuccess;
		String accept;
		String invalid;
		String nofriend;
		String friend;
		
		public String getFriend() {
			return friend;
		}



		public void setFriend(String friend) {
			this.friend = friend;
		}
		
		public String getNofriend() {
			return nofriend;
		}



		public void setNofriend(String nofriend) {
			this.nofriend = nofriend;
		}

		public String getInvalid() {
			return invalid;
		}



		public void setInvalid(String invalid) {
			this.invalid = invalid;
		}
		public String getAccept() {
			return accept;
		}



		public void setAccept(String accept) {
			this.accept = accept;
		}
		
		public String getUnsuccess() {
			return unsuccess;
		}



		public void setUnsuccess(String unsuccess) {
			this.unsuccess = unsuccess;
		}
		
		public String getAccepted() {
			return accepted;
		}



		public void setAccepted(String accepted) {
			this.accepted = accepted;
		}



		public String getRejected() {
			return rejected;
		}



		public String getLocalhost() {
			return localhost;
		}

		public String getEnd() {
			return end;
		}

		
		public String getOutput() {
			return output;
		}

		public void setOutput(String output) {
			this.output = output;
		}
//
		
		String output;
		public void setEnd(String end) {
			this.end = end;
		}

		String end;


		public void setLocalhost(String localhost) {
			this.localhost = localhost;
		}



		public String getSuccess() {
			return success;
		}



		public void setSuccess(String success) {
			this.success = success;
		}



		public String getNoresult() {
			return noresult;
		}



		public void setNoresult(String noresult) {
			this.noresult = noresult;
		}



		public String getNoelection() {
			return noelection;
		}



		public void setNoelection(String noelection) {
			this.noelection = noelection;
		}



		public String getNotfound() {
			return notfound;
		}



		public void setNotfound(String notfound) {
			this.notfound = notfound;
		}



		public String getStart() {
			return start;
		}



		public void setStart(String start) {
			this.start = start;
		}



		public String getException() {
			return exception;
		}



		public void setException(String exception) {
			this.exception = exception;
		}



		public String getFound() {
			return found;
		}



		public void setFound(String found) {
			this.found = found;
		}



		public String getView() {
			return view;
		}



		public void setView(String view) {
			this.view = view;
		}



		public void setRejected(String rejected) {
			this.rejected = rejected;
		}



		public String getMandatory() {
			return Mandatory;
		}



		public void setMandatory(String mandatory) {
			Mandatory = mandatory;
		}





		public String getNoElection() {
			return noElection;
		}



		public void setNoElection(String noElection) {
			this.noElection = noElection;
		}



		public String getNoResult() {
			return noResult;
		}



		public void setNoResult(String noResult) {
			this.noResult = noResult;
		}



		public String getNotFound() {
			return notFound;
		}



		public void setNotFound(String notFound) {
			this.notFound = notFound;
		}







		public String getInfo() {
			return info;
		}
		
		

		public void setInfo(String info) {
			this.info = info;
		}
		
		public String getDelete() {
			return delete;
		}



		public void setDelete(String delete) {
			this.delete = delete;
		}
		
		public String getNoCandidate() {
			return noCandidate;
		}



		public void setNoCandidate(String noCandidate) {
			this.noCandidate = noCandidate;
		}
		public String getFail() {
			return fail;
		}

		public void setFail(String fail) {
			this.fail = fail;
		}
		
		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getPending() {
			return pending;
		}

		public void setPending(String pending) {
			this.pending = pending;
		}

		public String getReject() {
			return reject;
		}

		public void setReject(String reject) {
			this.reject = reject;
		}

		
	}
	
}

