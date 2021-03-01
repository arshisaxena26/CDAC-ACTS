package pojos;

public class Candidate {
	// properties
	private int candidateID;
	private String name, party;
	private int votes;

	public Candidate() {
		// default Constructor
	}

	// Parameterized Constructor
	public Candidate(String name, String party) {
		this.name = name;
		this.party = party;
	}

	// Parameterized Constructor excluding auto-increment properties
	public Candidate(String name, String party, int votes) {
		this.name = name;
		this.party = party;
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
