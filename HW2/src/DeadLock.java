public class DeadLock {
	private boolean joy;

	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", name,
					bower.getName());
			bower.bowBack(this);
		}

		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", name,
					bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		});
	}

	public synchronized void guardedJoy() {
		while (!joy) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Joy and efficiency have been achieved!");
	}

	public synchronized void notifyJoy() {
		joy = true;
		notifyAll();
	}
	
}
