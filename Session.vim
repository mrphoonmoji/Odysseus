let SessionLoad = 1
let s:so_save = &g:so | let s:siso_save = &g:siso | setg so=0 siso=0 | setl so=-1 siso=-1
let v:this_session=expand("<sfile>:p")
silent only
silent tabonly
cd ~/Odysseus
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
let s:shortmess_save = &shortmess
if &shortmess =~ 'A'
  set shortmess=aoOA
else
  set shortmess=aoO
endif
badd +23 core/src/com/mygdx/game/MyGame.java
badd +59 core/src/com/mygdx/game/screens/MainMenuScreen.java
badd +15 core/src/com/mygdx/game/screens/MainGameScreen.java
badd +13 core/src/com/mygdx/game/enitities/PlayerSprites.java
badd +31 core/src/com/mygdx/game/enitities/PlayerBody.java
badd +9 core/src/com/mygdx/game/util/Constants.java
badd +1 desktop/src/com/mygdx/game/DesktopLauncher.java
badd +1 core/src/com/mygdx/game/world/WorldHandler.java
badd +3 core/src/com/mygdx/game/enitities/PlayerHandler.java
badd +1 core/src/com/mygdx/game/screens/GameInterface.java
argglobal
%argdel
edit core/src/com/mygdx/game/enitities/PlayerHandler.java
let s:save_splitbelow = &splitbelow
let s:save_splitright = &splitright
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd w
let &splitbelow = s:save_splitbelow
let &splitright = s:save_splitright
wincmd t
let s:save_winminheight = &winminheight
let s:save_winminwidth = &winminwidth
set winminheight=0
set winheight=1
set winminwidth=0
set winwidth=1
exe 'vert 1resize ' . ((&columns * 25 + 112) / 225)
exe 'vert 2resize ' . ((&columns * 199 + 112) / 225)
argglobal
enew
file NvimTree_1
balt core/src/com/mygdx/game/MyGame.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal nofen
lcd ~/Odysseus
wincmd w
argglobal
balt ~/Odysseus/core/src/com/mygdx/game/enitities/PlayerSprites.java
setlocal fdm=manual
setlocal fde=0
setlocal fmr={{{,}}}
setlocal fdi=#
setlocal fdl=0
setlocal fml=1
setlocal fdn=20
setlocal fen
silent! normal! zE
let &fdl = &fdl
let s:l = 3 - ((2 * winheight(0) + 33) / 66)
if s:l < 1 | let s:l = 1 | endif
keepjumps exe s:l
normal! zt
keepjumps 3
normal! 0
lcd ~/Odysseus
wincmd w
2wincmd w
exe 'vert 1resize ' . ((&columns * 25 + 112) / 225)
exe 'vert 2resize ' . ((&columns * 199 + 112) / 225)
tabnext 1
if exists('s:wipebuf') && len(win_findbuf(s:wipebuf)) == 0 && getbufvar(s:wipebuf, '&buftype') isnot# 'terminal'
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20
let &shortmess = s:shortmess_save
let &winminheight = s:save_winminheight
let &winminwidth = s:save_winminwidth
let s:sx = expand("<sfile>:p:r")."x.vim"
if filereadable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &g:so = s:so_save | let &g:siso = s:siso_save
nohlsearch
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
