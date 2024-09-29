//package com.votingSystem.entity;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
// 
//
// 
//
//@Entity
//public class Candidate {
//	
//
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private int candidateId;
//	    private String candidateName;
//	    private String partyName;
//	    private MultipartFile partLogo;
//	    
//		public Candidate() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public Candidate(String candidateName, String partyName, MultipartFile partLogo) {
//			super();
//			this.candidateName = candidateName;
//			this.partyName = partyName;
//			this.partLogo = partLogo;
//		}
//
//		public Candidate(int candidateId, String candidateName, String partyName, MultipartFile partLogo) {
//			super();
//			this.candidateId = candidateId;
//			this.candidateName = candidateName;
//			this.partyName = partyName;
//			this.partLogo = partLogo;
//		}
//
//		public int getCandidateId() {
//			return candidateId;
//		}
//
//		public void setCandidateId(int candidateId) {
//			this.candidateId = candidateId;
//		}
//
//		public String getCandidateName() {
//			return candidateName;
//		}
//
//		public void setCandidateName(String candidateName) {
//			this.candidateName = candidateName;
//		}
//
//		public String getPartyName() {
//			return partyName;
//		}
//
//		public void setPartyName(String partyName) {
//			this.partyName = partyName;
//		}
//
//		public MultipartFile getPartLogo() {
//			return partLogo;
//		}
//
//		public void setPartLogo(MultipartFile partLogo) {
//			this.partLogo = partLogo;
//		}
//
//		@Override
//		public String toString() {
//			return "/n candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", partyName="
//					+ partyName + ", partLogo=" + partLogo + "]";
//		}
//	    
//	    
//	    
//	    
//	     
//	     
//	    
//
//}
