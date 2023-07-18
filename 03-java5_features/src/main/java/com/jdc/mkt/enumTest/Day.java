package com.jdc.mkt.enumTest;

public enum Day implements MySuper{


	MON("Monday") {
		@Override
		public void showFullName() {
			System.out.println("Monday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with mon");	
		}
	},
	TUE("Tuesday") {
		@Override
		public void showFullName() {
			System.out.println("Tuesday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with tue");	
		}
	},
	WED("Wednesday") {
		@Override
		public void showFullName() {
			System.out.println("Wednesday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with wed");	
		}
	},
	THUR("Thursday") {
		@Override
		public void showFullName() {
			System.out.println("Thursday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with thur");
		}
	},
	FRI("Friday") {
		@Override
		public void showFullName() {
			System.out.println("Friday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with fri");
		}
	},
	SAT("Saturday") {
		@Override
		public void showFullName() {
			System.out.println("Saturday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with Sat");
		}
	},
	SUN("Sunday") {
		@Override
		public void showFullName() {
			System.out.println("Sunday");
		}

		@Override
		public void doWork() {
			System.out.println("Working with Sun");
		}
	};

	private String name;

	public abstract void showFullName();

	Day(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Day Value :" + name();
	}
}
