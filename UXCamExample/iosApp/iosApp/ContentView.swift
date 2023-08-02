import SwiftUI
import shared

struct ContentView: View {

    init() {
        UXCamExample().start()
    }

	@ViewBuilder var body: some View {
		Text("UXCam example")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}