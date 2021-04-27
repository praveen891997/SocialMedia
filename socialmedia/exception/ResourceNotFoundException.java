package com.cg.socialmedia.exception;

public class ResourceNotFoundException extends Exception {
		private String message;

		public ResourceNotFoundException(String message) {
			super();
			this.message = message;
		}

		public ResourceNotFoundException() {
			super();
		}

		@Override
		public String toString() {
			return "ResourceNotFoundException [message=" + message + "]";
		}

    
}
