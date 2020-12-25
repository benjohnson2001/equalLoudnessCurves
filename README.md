The frequency balance of any audio changes at different volumes because of how our ears work, these equal loudness curves let you shape a sound to make it sound how it does at louder and quieter volumes without changing its character.

![equalLoudnessCurves.gif](equalLoudnessCurves.gif)

how to install

[download](https://raw.githubusercontent.com/benjohnson2001/equalLoudnessCurves/master/equalLoudnessCurves.RPL)

These curves were created from the ISO226 curves (updated version of Fletcher-Munson), specifically 1 base unit (bU) is the difference between the 44 phon and 40 phon ISO226 curves. I bought Slick EQ M specifically for its equal loudness curve, it works well but it's really only meant for small adjustments. I ended up using it for creative purposes and needed so many instances that it got to the point where even with Eco mode turned on it required more CPU than I had available, so this is why I made these. There isn't any real difference between the 50bU curve and 50 instances of the 1bU curve, but it saves a lot of CPU. Special thanks to [this guy](https://www.mathworks.com/matlabcentral/fileexchange/7028-iso-226-equal-loudness-level-contour-signal), you can also check out my matlab session [here](https://raw.githubusercontent.com/benjohnson2001/equalLoudnessCurves/master/matlabSession.txt) to see how the data for these curves was generated
