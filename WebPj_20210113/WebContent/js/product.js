const tl = new TimelineMax();

tl.add('start')
tl.to('.sky-bk', 1, {
  scaleY: 1.45,
  ease: Sine.easeOut
}, 'start+=2')
tl.to('.services, .manage', 0.5, {
  opacity: 0,
  ease: Sine.easeIn
}, 'start+=2')

tl.to('.in, .aas', 1, {
  opacity: 1,
  ease: Sine.easeOut
}, 'start+=2.8')

tl.to('.sky-bk', 1, {
  scaleY: 0.95,
  ease: Sine.easeOut
}, 'start+=5.5')
tl.to('.in', 0.5, {
  opacity: 0,
  ease: Sine.easeIn
}, 'start+=5.5')

tl.to('.pn', 1, {
  opacity: 1,
  ease: Sine.easeOut
}, 'start+=6.3')

tl.to('.sky-bk', 1, {
  scaleY: 0.73,
  ease: Sine.easeOut
}, 'start+=8')
tl.to('.pn', 0.5, {
  opacity: 0,
  ease: Sine.easeIn
}, 'start+=8')

tl.to('.fn', 1, {
  opacity: 1,
  ease: Sine.easeOut
}, 'start+=8.6')