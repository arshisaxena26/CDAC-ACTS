package pojos;

public class Candidate {
	// properties
	private int candidateID;
	private String name, party;
	private int votes;

	public Candidate() {
		// default Constructor
	}

	// Parameterized Constructors as required by DAO Layer

	public Candidate(int candidateID, String name, String party) {
		this.candidateID = candidateID;
		this.name = name;
		this.party = party;
	}

	public Candidate(String name, int votes) {
		this.name = name;
		this.votes = votes;
	}

	// Getters and Setters
	public int getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [candidateID=" + candidateID + ", name=" + name + ", party=" + party + ", votes=" + votes
				+ "]";
	}
}
