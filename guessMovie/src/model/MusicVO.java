package model;
	public class MusicVO {
		// Music의 설계도 만들기
		// VO = Value Object
		// 필드만들기 -> 생성자를 이용해서 초기값을 가진 객체를 만들기.
		
		// 제목, 가수명, 음악길이(초), 음악파일의 경로.
		private String title;
		private String singer;
		private String musicPath;
		
		//생성자
		public MusicVO(String title, String singer, String musicPath) {
			this.title = title;
			this.singer = singer;
			this.musicPath = musicPath;
		}

		//Getter
		public String getTitle() {
			return title;
		}

		public String getSinger() {
			return singer;
		}


		public String getMusicPath() {
			return musicPath;
		}
		
		
		
		
		
	}


