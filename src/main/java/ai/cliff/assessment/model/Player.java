package ai.cliff.assessment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity //declaring as Entity
@Table(name ="players") //giving table name
public class Player {
	
		@Id
		@JsonFormat(shape = JsonFormat.Shape.NUMBER)
		private int playerid;//made teamid as primary key for teams table which will be autogenerated value
		
		//formating name and age
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private String playername;
		
		@JsonFormat(shape = JsonFormat.Shape.NUMBER)
		private int playerage;
			
		//formating date format for createdat and updatedat columns
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		private Date createdat;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		private Date updatedat;

		@JsonFormat(shape=JsonFormat.Shape.NUMBER)
		private int pteamId;
		
		
		//Generating getters and setters
		public int getPteamId() {
			return pteamId;
		}
		public void setPteamId(int pteamId) {
			this.pteamId = pteamId;
		}
		public int getPlayerid() {
			return playerid;
		}
		public void setPlayerid(int playerid) {
			this.playerid = playerid;
		}
		public String getPlayername() {
			return playername;
		}
		public void setPlayername(String playername) {
			this.playername = playername;
		}
		public int getPlayerage() {
			return playerage;
		}
		public void setPlayerage(int playerage) {
			this.playerage = playerage;
		}
		public Date getCreatedat() {
			return createdat;
		}
		public void setCreatedat(Date createdat) {
			this.createdat = createdat;
		}
		public Date getUpdatedat() {
			return updatedat;
		}
		public void setUpdatedat(Date updatedat) {
			this.updatedat = updatedat;
		}
		
		
}
