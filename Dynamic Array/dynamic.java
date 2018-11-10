
public class dynamic {

	private int data[];
	  private  int nextIndex;

		public dynamic() {
			data = new int[5];
		}
		public boolean isEmpty() {
			if (size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public int removeLast() {
			if (nextIndex < 1) {
				// error out
				return -1;
				
			}
			int value = data[nextIndex - 1];
			data[nextIndex - 1] = 0;
			nextIndex--;
			return value;
		}

		public void restructure() {
			int temp[] = data;
			data = new int[data.length * 2];
			for (int i = 0; i < temp.length; i++) {
				data[i] = temp[i];
			}
		}

		public void add(int element) {
			if (nextIndex == data.length) {
				restructure();
			}
			data[nextIndex] = element;
			nextIndex++;
		}

		public int size() {
			return nextIndex;
		}

		public int get(int index) {
			if (index < 0 || index >= nextIndex) {
				return -1;
			}
			return data[index];
		}

		public void set(int index, int element) {

			if (index > nextIndex) {
			  throw new ArrayIndexOutOfBoundsException("Index out of bound");
			  
		//	  throw new stackException("Exception");
			  //throw new UserDefined();
				//return;
			} else if (index == nextIndex) {
				add(element);
			} else {
				data[index] = element;
			
			}

		}
	}

