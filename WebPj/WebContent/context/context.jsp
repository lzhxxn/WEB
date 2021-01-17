<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board, board.mvc.vo.ListResult"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../css/product.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/product.js'></script>

<div style="float:right;" class="blog-member">
   <c:if test="${!empty loginPassUser}">
         <span class="blog-member__text">${loginPassUser.name} 님</span> 
   </c:if>
   <c:choose>
      <c:when test="${empty loginPassUser}">
         <a href="../login/login.do?m=check" class="blog-member__login">로그인</a>
      </c:when>
       <c:otherwise>
         <a href="../login/login.do?m=out" class="blog-member__logout">로그아웃</a>
       </c:otherwise>
   </c:choose>
</div>

<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="5 5 1155 1315">
  <defs>
    <linearGradient id="k" x1="638.49" x2="545.62" y1="1260.93" y2="358.77" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#707f91"/>
      <stop offset=".13" stop-color="#798798"/>
      <stop offset=".35" stop-color="#939eac"/>
      <stop offset=".62" stop-color="#bcc3cb"/>
      <stop offset=".95" stop-color="#f5f6f7"/>
      <stop offset="1" stop-color="#fff"/>
    </linearGradient>
    <linearGradient id="a" x1="315.83" x2="716.72" y1="666.8" y2="2007.76" gradientUnits="userSpaceOnUse">
      <stop offset=".01" stop-color="#add6de"/>
      <stop offset=".35" stop-color="#cee7eb"/>
      <stop offset=".77" stop-color="#f2f8fa"/>
      <stop offset="1" stop-color="#fff"/>
    </linearGradient>
    <linearGradient id="l" x1="805.59" x2="1206.48" y1="517.79" y2="1858.75" xlink:href="#a"/>
    <linearGradient id="m" x1="581.93" x2="982.82" y1="584.65" y2="1925.61" xlink:href="#a"/>
    <linearGradient id="n" x1="867.29" x2="1268.18" y1="499.34" y2="1840.3" xlink:href="#a"/>
    <radialGradient id="o" cx="1160" cy="1564.78" r="329.71" gradientTransform="matrix(1 0 0 2.38 0 -2813.8)" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#008e9e"/>
      <stop offset="1"/>
    </radialGradient>
    <linearGradient id="p" x1="776.54" x2="1177.43" y1="526.47" y2="1867.43" xlink:href="#a"/>
    <radialGradient id="q" cx="1516.4" cy="1039.83" r="465.52" gradientTransform="matrix(1 -.09 .1 1.16 -213.65 -107.93)" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#002024"/>
      <stop offset="1"/>
    </radialGradient>
    <linearGradient id="r" x1="972.79" x2="1373.68" y1="467.8" y2="1808.76" xlink:href="#a"/>
    <linearGradient id="s" x1="903.5" x2="1304.39" y1="488.52" y2="1829.48" xlink:href="#a"/>
    <linearGradient id="t" x1="53.91" x2="1227.96" y1="23.1" y2="623.21" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#55c6d5"/>
      <stop offset=".22" stop-color="#53c5d1"/>
      <stop offset=".45" stop-color="#4bc3c4"/>
      <stop offset=".69" stop-color="#40bfb0"/>
      <stop offset=".92" stop-color="#2fba93"/>
      <stop offset=".99" stop-color="#29b889"/>
    </linearGradient>
    <radialGradient id="u" cx="622.01" cy="802.2" r="408.92" gradientUnits="userSpaceOnUse">
      <stop offset=".01" stop-color="#00243f"/>
      <stop offset=".14" stop-color="#002743" stop-opacity=".83"/>
      <stop offset=".78" stop-color="#003456" stop-opacity="0"/>
      <stop offset="1" stop-color="#00426a" stop-opacity="0"/>
    </radialGradient>
    <linearGradient id="b" x1="231.39" x2="292.34" y1="281.32" y2="281.32" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#f5fffd"/>
      <stop offset="1" stop-color="#f6ffff"/>
    </linearGradient>
    <linearGradient id="v" x1="177.06" x2="247.95" y1="281.32" y2="281.32" xlink:href="#b"/>
    <linearGradient id="w" x1="154.69" x2="189.24" y1="233.76" y2="233.76" xlink:href="#b"/>
    <linearGradient id="x" x1="123.89" x2="163.33" y1="233.76" y2="233.76" xlink:href="#b"/>
    <linearGradient id="y" x1="850.25" x2="884.81" y1="325.87" y2="325.87" xlink:href="#b"/>
    <linearGradient id="z" x1="819.46" x2="858.9" y1="325.87" y2="325.87" xlink:href="#b"/>
    <radialGradient id="A" cx="656.8" cy="852.44" r="0" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#3eeae2"/>
      <stop offset=".07" stop-color="#38d9d2"/>
      <stop offset=".3" stop-color="#24a4a0"/>
      <stop offset=".52" stop-color="#157a79"/>
      <stop offset=".71" stop-color="#0a5c5d"/>
      <stop offset=".88" stop-color="#034a4c"/>
      <stop offset="1" stop-color="#014346"/>
    </radialGradient>
    <linearGradient id="c" x1="817.67" x2="785.48" y1="545.04" y2="705.38" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#21daff"/>
      <stop offset="1" stop-color="#0c6ca8"/>
    </linearGradient>
    <linearGradient id="B" x1="661.93" x2="616.02" y1="997.76" y2="741.81" xlink:href="#c"/>
    <linearGradient id="d" x1="666.38" x2="694.71" y1="583.84" y2="684.16" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#88e6f2"/>
      <stop offset="1" stop-color="#00a0d1"/>
    </linearGradient>
    <linearGradient id="g" x1="500.74" x2="536.29" y1="597.89" y2="1087.24" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#3bd8f7"/>
      <stop offset="1" stop-color="#b4edf3"/>
    </linearGradient>
    <linearGradient id="C" x1="719.38" x2="771.71" y1="565.94" y2="643.49" xlink:href="#d"/>
    <linearGradient id="D" x1="385.95" x2="385.95" y1="578.73" y2="769.59" xlink:href="#c"/>
    <linearGradient id="E" x1="393.86" x2="341" y1="566.08" y2="640.42" xlink:href="#d"/>
    <linearGradient id="e" x1="521.36" x2="433.52" y1="1055.85" y2="693.53" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#0a4868"/>
      <stop offset="1" stop-color="#1182b2"/>
    </linearGradient>
    <linearGradient id="F" x1="614.07" x2="663.35" y1="973.76" y2="1057.88" xlink:href="#e"/>
    <linearGradient id="f" x1="661.96" x2="646.35" y1="922.05" y2="1149.21" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#0c83a8"/>
      <stop offset="1" stop-color="#52e2ff"/>
    </linearGradient>
    <linearGradient id="h" x1="657.96" x2="812.44" y1="686.79" y2="870.02" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#0c6ca8"/>
      <stop offset="1" stop-color="#21daff"/>
    </linearGradient>
    <linearGradient id="G" x1="542.3" x2="542.35" y1="597.54" y2="597.86" xlink:href="#d"/>
    <linearGradient id="H" x1="542.28" x2="542.35" y1="597.7" y2="598.19" xlink:href="#d"/>
    <linearGradient id="I" x1="497.34" x2="497.53" y1="602.73" y2="602.12" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#0c83a8"/>
      <stop offset="1" stop-color="#27b9d6"/>
    </linearGradient>
    <linearGradient id="J" x1="771.39" x2="771.39" y1="630.83" y2="501.97" xlink:href="#f"/>
    <linearGradient id="K" x1="602.88" x2="562.25" y1="542.97" y2="1133.2" xlink:href="#c"/>
    <linearGradient id="L" x1="630.48" x2="630.46" y1="595.16" y2="595.23" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#3789b0"/>
      <stop offset="1" stop-color="#1f6f90"/>
    </linearGradient>
    <linearGradient id="M" x1="661.78" x2="621.69" y1="476.64" y2="642.01" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#8ae1f2"/>
      <stop offset="1" stop-color="#3dc8ec"/>
    </linearGradient>
    <linearGradient id="N" x1="573.93" x2="630.24" y1="551.28" y2="272.59" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#89edff"/>
      <stop offset="1" stop-color="#ececec"/>
    </linearGradient>
    <linearGradient id="j" x1="556.6" x2="657.93" y1="5747.41" y2="5646.08" gradientTransform="matrix(1 0 0 -1 2 6145.62)" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#9ce3ec"/>
      <stop offset="1" stop-color="#60dbf2"/>
    </linearGradient>
    <linearGradient id="O" x1="519.37" x2="519.99" y1="607.01" y2="493.29" xlink:href="#g"/>
    <linearGradient id="P" x1="540.9" x2="540.97" y1="597.31" y2="597.77" xlink:href="#d"/>
    <linearGradient id="Q" x1="531.25" x2="581.45" y1="412.76" y2="741.02" xlink:href="#d"/>
    <linearGradient id="R" x1="492.89" x2="541.46" y1="587.64" y2="431.83" xlink:href="#f"/>
    <linearGradient id="S" x1="700.88" x2="700.88" y1="993.31" y2="551.7" xlink:href="#h"/>
    <linearGradient id="T" x1="705.93" x2="705.93" y1="596.7" y2="508.48" xlink:href="#f"/>
    <linearGradient id="U" x1="751.15" x2="715.66" y1="595.82" y2="472.04" xlink:href="#h"/>
    <linearGradient id="i" x1="513.92" x2="557.46" y1="5751.74" y2="5708.2" gradientTransform="matrix(1 0 0 -1 2 6145.62)" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#d0f4ff"/>
      <stop offset="1" stop-color="#e9f6fb"/>
    </linearGradient>
    <linearGradient id="V" x1="584.4" x2="578.05" y1="5655.12" y2="5835.26" xlink:href="#i"/>
    <linearGradient id="W" x1="611.6" x2="543.85" y1="450.57" y2="286.34" xlink:href="#j"/>
    <linearGradient id="X" x1="-1801.43" x2="-1798.99" y1="3806.12" y2="3803.68" gradientTransform="matrix(33 0 0 17 60042 -64255.4)" xlink:href="#i"/>
    <linearGradient id="Y" x1="666.75" x2="666.75" y1="479.75" y2="388.07" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#33d8fc"/>
      <stop offset="1" stop-color="#339da3"/>
    </linearGradient>
    <linearGradient id="Z" x1="419.99" x2="424.65" y1="509.64" y2="597.89" xlink:href="#i"/>
    <linearGradient id="aa" x1="764.56" x2="764.56" y1="597.49" y2="597.55" gradientUnits="userSpaceOnUse">
      <stop offset="0" stop-color="#25a0cc"/>
      <stop offset="1" stop-color="#0a7688"/>
    </linearGradient>
    <linearGradient id="ab" x1="456.67" x2="456.67" y1="796.42" y2="453.87" xlink:href="#g"/>
    <linearGradient id="ac" x1="585.61" x2="512.31" y1="511.81" y2="750.05" xlink:href="#d"/>
    <linearGradient id="ad" x1="565.92" x2="466.13" y1="672.55" y2="996.85" gradientTransform="rotate(-21.8 504.212 775.4)" xlink:href="#d"/>
    <linearGradient id="ae" x1="620.94" x2="584.71" y1="809.76" y2="683.42" gradientTransform="matrix(-1.5 -.66 .67 -1.52 1025.22 2270.28)" xlink:href="#h"/>
    <linearGradient id="af" x1="460.35" x2="460.31" y1="506.81" y2="506.97" xlink:href="#d"/>
  </defs>
  <g style="isolation:isolate">
    <path fill="#008391" d="M2 79.3h1160v1261.79H2z" data-name="BG color"/>
    <path fill="#096c7d" d="M625.7 1096.4L609 1090l-23.2-3.6-17.1-1.5-13.9-11.3-12.4-4.8-27-6.4-25.9-6.5-21.4-4.3-19.2-7.4-3.4-26.8v-15.5l-1-6.6-7.1 3.4-4.3 9.9-12.3 29.8-5.6 9.4-33.5 8.5-13.9.8-42.5-.8-24.7 2-16.5 9.4-6.4 4-1.4 9.1 9.4 16.5 35.4 26.6 12.4 5.4-2.6 6.8-9.7 21.7 5.4 22.9 9.4 3.9 10.8-1.3 16.1-29.6-4.6-16.1 31.3 8 12.7-1.3 24.8 24.5 10.5 3.1 7.2-.4-5.9-8.2-16.9-23.1-21.9-10.9-7.8-10.5 7.8 10.5 21.9 10.9 34.4-3.1 10.6-4.8 29.3-8.3 14.3-14.7-14.3 14.7 36-17.1 9.7-1.1-5.1 6.9-1.9 10.4 2.8-1.6 3.7-2.3 23.2-7.3 12.1-1.3 2.7-5.6 6.8 2 10.2-1.8 19.8-4.1 15.8 1.6z"/>
    <path fill="#0D6271" d="M2 79.3h1160v1265.79H2z" opacity=".51"/>
    <path fill="none" d="M781.2 2083H624l-144.1-737.9-140-716.6L815 597.9l40.2 27.5c6.8-41.3 15.1-80.9 24.6-118.5l-660.1-3v2014.2H1162V2083z"/>
    <path fill="#0D6271" d="M339.9 628.5l140 716.6h77.4L339.9 628.5z" opacity=".7" />
    <path fill="url(#l)" d="M853.2 623.4L813 595.9l39.1 34.3c.3-2.3.7-4.5 1.1-6.8z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="#0D6271" d="M884.6 1343.1c-34.3-123.9-54.3-272.4-54.3-431.9 0-99 7.7-193.8 21.8-281L813 595.9l-475.1 30.6 217.4 716.6z" opacity=".7" transform="translate(2 2)"/>
    <path fill="#054c59" d="M884.6 1343.1c-34.3-123.9-54.3-272.4-54.3-431.9 0-99 7.7-193.8 21.8-281L813 595.9l-475.1 30.6 217.4 716.6z" opacity=".15" transform="translate(2 2)"/>
    <path fill="url(#n)" d="M976.1 738.9c3.1-8.3 6.4-16.4 9.9-24.4l-132.8-91.1c-.4 2.3-.8 4.5-1.1 6.8z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="#278793" d="M976.1 738.9c3.1-8.3 6.4-16.4 9.9-24.4l-132.8-91.1c-.4 2.3-.8 4.5-1.1 6.8z" opacity=".08"  transform="translate(2 2)"/>
    <path fill="url(#p)" d="M830.3 911.2c0 159.5 20 308 54.3 431.9h189.1c-73.2-87.6-122.6-203.1-134-332.7-8.5-96.8 5.2-189.5 36.4-271.5l-124-108.7c-14.1 87.2-21.8 182-21.8 281z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="url(#p)" d="M830.3 911.2c0 159.5 20 308 54.3 431.9h189.1c-73.2-87.6-122.6-203.1-134-332.7-8.5-96.8 5.2-189.5 36.4-271.5l-124-108.7c-14.1 87.2-21.8 182-21.8 281z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="#278793" d="M830.3 911.2c0 159.5 20 308 54.3 431.9h189.1c-73.2-87.6-122.6-203.1-134-332.7-8.5-96.8 5.2-189.5 36.4-271.5l-124-108.7c-14.1 87.2-21.8 182-21.8 281z" opacity=".08" transform="translate(2 2)"/>
    <path fill="url(#q)" d="M986 714.5l174 119.3V506.1h-10.8C1079.3 556.9 1023 629.2 986 714.5z" style="mix-blend-mode:screen" transform="translate(2 2)"/>
    <path fill="#278793" d="M986 714.5l174 119.3V506.1h-10.8C1079.3 556.9 1023 629.2 986 714.5z" opacity=".08"  transform="translate(2 2)"/>
    <path fill="url(#r)" d="M976.1 738.9L1160 900.2v-66.4L986 714.5c-3.5 8-6.8 16.1-9.9 24.4z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="url(#q)" d="M976.1 738.9L1160 900.2v-66.4L986 714.5c-3.5 8-6.8 16.1-9.9 24.4z" style="mix-blend-mode:screen" transform="translate(2 2)"/>
    <path fill="url(#o)" d="M976.1 738.9L1160 900.2v-66.4L986 714.5c-3.5 8-6.8 16.1-9.9 24.4z" opacity=".08" style="mix-blend-mode:screen" transform="translate(2 2)"/>
    <path fill="url(#s)" d="M939.7 1010.4c11.4 129.6 60.8 245.1 134 332.7h86.3V900.2L976.1 738.9c-31.2 82-44.9 174.7-36.4 271.5z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="url(#s)" d="M939.7 1010.4c11.4 129.6 60.8 245.1 134 332.7h86.3V900.2L976.1 738.9c-31.2 82-44.9 174.7-36.4 271.5z" opacity=".7" style="mix-blend-mode:multiply" transform="translate(2 2)"/>
    <path fill="url(#q)" d="M939.7 1010.4c11.4 129.6 60.8 245.1 134 332.7h86.3V900.2L976.1 738.9c-31.2 82-44.9 174.7-36.4 271.5z" style="mix-blend-mode:screen" transform="translate(2 2)"/>
    <path fill="url(#o)" d="M939.7 1010.4c11.4 129.6 60.8 245.1 134 332.7h86.3V900.2L976.1 738.9c-31.2 82-44.9 174.7-36.4 271.5z" opacity=".08" style="mix-blend-mode:screen" transform="translate(2 2)"/>
    <path class="sky-bk" fill="url(#t)" stroke="#12aec9" stroke-miterlimit="10" stroke-width="4" d="M2 2v582.1l120.6 13.4h128.2l175.7-13.7 82.8 9.5 191.4-9.2 88.5 9.2h84.6L982 585l46.8 8.3 133.2-9.2V2H2z"/>
    <circle cx="622" cy="802.2" r="408.9" fill="url(#u)"/>
    <g data-name="sky">
      <path fill="url(#b)" d="M292.3 280.1l-21.4-10.8-39.5 24.1 39.5-13.9 21.4.6z"/>
      <path fill="url(#v)" d="M177.1 290.9l30.4-21.6 29.6 10.2 10.8 3.8-16.5 10.1-17.3-15.3-37 12.8z"/>
      <path fill="#66a0b0" d="M231.4 293.4l9.5-3.4-26.8-11.9 17.3 15.3z"/>
      <g data-name="bird" opacity=".5">
        <path fill="url(#w)" d="M189.2 234.1l-12.1-8.2-22.4 15.7 22.4-7.8 12.1.3z"/>
        <path fill="url(#x)" d="M123.9 240.2l17.3-14.3 16.7 7.9 5.4 1.8-8.6 6-9.8-8.7-21 7.3z"/>
        <path fill="#66a0b0" d="M154.7 241.6l5.4-1.9-15.2-6.8 9.8 8.7z"/>
      </g>
      <g data-name="bird" opacity=".5">
        <path fill="url(#y)" d="M884.8 326.2l-12.1-8.2-22.4 15.7 22.4-7.8 12.1.3z"/>
        <path fill="url(#z)" d="M819.5 332.3l17.2-14.3 16.8 7.9 5.4 1.8-8.6 6-9.9-8.6-20.9 7.2z"/>
        <path fill="#66a0b0" d="M850.3 333.7l5.3-1.8-15.2-6.8 9.9 8.6z"/>
      </g>
    </g>
    <g data-name="iceberg bottom part">
      <g data-name="iceberg bottom">
        <path fill="url(#A)" d="M656.8 852.4z"/>
        <path fill="url(#c)" d="M842.7 669.7L798.4 719c-.1.1-.2 0-.3 0h-.1v-95.6c-.5-1.4-7.4-17.3-15.1-35.8-.7-1.8-12.9-48.9-13.6-50.7l40.5 46.6v.4h.2l32.6 85.7z" transform="translate(2 2)"/>
        <path fill="url(#B)" d="M639.8 578.8l-3.6 202.9-.6 69.4-72.1 135 33.6 45.4 44.3-97.8 32.3-66.1 23.6-209.8-57.5-79z"/>
        <path fill="url(#d)" d="M697.3 657.8l-57.4-79h-.1.4v-.4H690v.4h.1l7.2 79z"/>
        <path fill="url(#g)" d="M543.4 808.5l-12 157.3-57.7-153.4 21.5-228.9v-.1h1.2v-.3h45.8v.2l.1.2h-.5l.5 62.4 1.1 162.6z"/>
        <path fill="url(#C)" d="M752.1 628.6l-30.3-45.1v-.1l-.1-.3h18.8l.1.3h.1v.1l11.4 45.1z"/>
        <path fill="url(#D)" d="M421.4 775.1L338.7 660l-7.4-43.5 42.3-34.4h-.2l.2-.4 67 1.4-.1.3v.1l-19.1 191.6z"/>
        <path fill="url(#E)" d="M329.3 614.5l42.3-34.4h-.2l.2-.4 41.2 1.4a.5.5 0 0 1 .3.3z" transform="translate(2 2)"/>
        <path fill="url(#e)" d="M531.4 965.8l-57.7-153.4-52.3-37.3 52 109.6 57.8 166.5.2-85.4z"/>
        <path fill="url(#F)" d="M597.1 1031.5l44.3-97.8 2 153.6-46.3-55.8z"/>
        <path fill="url(#f)" d="M673.7 867.6l-32.3 66.1 2 153.6 35.3-121.5-5-98.2z"/>
        <path fill="url(#h)" d="M800.1 721.3l4.8-81.6-18.5-54.5-.3-.8h-.4l-.2-.4-45-.9.1.3.1.1 11.4 45.1-6.1 103.6-67.3 233.6 109.9-174.3 11.5-70.2z"/>
        <path fill="url(#G)" d="M542.3 597.6v.1-.1z"/>
        <path fill="url(#H)" d="M542.3 597.9v-.2l.1.3h-.1v-.1z"/>
        <path fill="url(#I)" d="M498 602.2v.4h-1.1v-.4h1.1z"/>
        <path fill="url(#J)" d="M800.3 630.2l-40.7-34.6c-8.3-19.9-16.7-55.8-17.1-56.7v-.2l12.7-50a.2.2 0 0 1 .3 0l30.8 107.5v-2.4z" transform="translate(2 2)"/>
        <path fill="url(#K)" d="M640.2 578.8v-.4l-11.9.9-13.6-87.6-38.3 91.3-1.9.1-.2.3v.1h.1l-32.1 62.4-.5.9 1.6 161.7-12 157.3-.2 85.4 32.3-65.1 72.1-135 .6-69.4 3.6-202.9h.4z"/>
        <path fill="url(#L)" d="M630.5 595.2h-.1v-.1l.1.1z"/>
        <path fill="url(#M)" d="M676.5 595.2l-36.7-16.4-.3 18.5-.9 53.7v-5.6l-23.9-153.7 35-25.3 13 23.9 13.8 104.8v.1z"/>
        <path fill="url(#N)" d="M570.4 597.5v.1h-29.8v-.1h.3v-.2l17.2-109.7 56.6 4.1-44.4 105.8h.1z"/>
        <path fill="url(#j)" d="M614.7 491.7l-23.9-20-7-54.3 23.3-12 41.8 52.3.8 8.7-35 25.3z"/>
        <path fill="url(#O)" d="M541 597.6l-43.2 4.6h1.1l19.7-109.5 22.3 104.6.1.3z"/>
        <path fill="url(#P)" d="M541 597.6h-.1V597.3l.1.3z"/>
        <path fill="url(#Q)" d="M558.1 425.5v62.1l-17.2 109.7-22.3-104.6 10.3-7.7 29.2-59.5z"/>
        <path fill="url(#R)" d="M558.1 425.5L528.9 485l-10.3 7.7-19.7 109.5h-1.1.1l11.6-114.8 48.6-61.9z"/>
        <path fill="url(#S)" d="M740.7 583.5v-.1h-.1l-.1-.3h-18.8l-18.9-2.8-13.8-74-4.4-45.7-34.9 5.8 13 23.9 13.8 104.8v.1h15.1l5.7 62.6-23.6 209.8 2.5 48.2 2.5 50L746 732.2l6.1-103.6-11.4-45.1z"/>
        <path fill="url(#T)" d="M722.9 595.2h-17.3v-.1L689 506.3l22.1 39 11.8 49.8v.1z"/>
        <path fill="url(#U)" d="M764.6 597.6l-41.7-2.4v-.1l-11.8-49.8-22.1-39-4.4-45.7 72.7 29.5-.1.6-12.7 50v.2l19.7 56.6h.4v.1z"/>
        <path fill="url(#i)" d="M558.1 425.5l-48.6 61.9-43-26 40.8-12 67.1-114-16.3 90.1z"/>
        <path fill="url(#V)" d="M558.1 487.6v-62.1l16.3-90.1 9.4 82 7 54.3 23.9 20-56.6-4.1z"/>
        <path fill="url(#W)" d="M583.8 417.4l23.3-12-32.7-70 9.4 82z" data-name="triangle36"/>
        <path fill="url(#X)" d="M607.1 405.4l41.8 52.3 4.3-61.8-46.1 9.5z" data-name="triangle36"/>
        <path fill="url(#Y)" d="M649.7 466.4l-.8-8.7 4.3-61.8 31.4 64.7-34.9 5.8z"/>
        <path fill="url(#Z)" d="M447.7 597.5v.1l-62.9-2.4 10.2-32.6 64.5-56.3-11.8 91.2z"/>
        <path fill="url(#aa)" d="M764.6 597.6h-.1l.1-.1v.1z"/>
        <path fill="url(#ab)" d="M466.5 461.4l-13.3 85.4-19.8 50.7h.1l-29.7 59 17.6 118.6 52.3 37.3L493.5 602l4.3.2h.1l11.6-114.8-43-26z"/>
        <path fill="url(#ac)" d="M574.4 589.8v.1l-32.1 68.6-.5 1v-69.7h.4V589.5l60.9-70.2-28.8 70.5h.1z"/>
        <path fill="url(#ad)" d="M541.8 734.7l-.1.1 1.7 73.7-4.4 57.9-27.5-119.6.3-.2v-.2l-.1-.2 30.6-87.7 1.4 76.2h-1.9z"/>
        <path fill="url(#ae)" d="M608 651l31.2-34.5.6 83.5 4.7 31.5 6.8 74.2L627 878l6.7-84-26-29.9-16.4-47.8.1-.1v-.1l19.6-23.4-3-41.7z"/>
      </g>
      <path fill="url(#af)" d="M460.3 506.8h.1v.1"/>
    </g>
    <g>
      <path fill="none" stroke="#f6ffff" stroke-miterlimit="10" d="M494.2 916.2l-135.9 37.9H99.1"/>
      <path fill="#f6ffff" d="M504.8 913.2a5.8 5.8 0 1 0-5.8 5.8 5.8 5.8 0 0 0 5.8-5.8z"/>
      <path fill="#f60" d="M501.4 913.2a2.4 2.4 0 1 0-2.4 2.4 2.4 2.4 0 0 0 2.4-2.4z"/>
      <path fill="none" stroke="#f6ffff" stroke-miterlimit="10" d="M773 736.9l64.6 64.6h171.7"/>
      <path fill="#f6ffff" d="M767.2 736.9a5.8 5.8영어 0 1 1 5.8 5.8 5.8 5.8 0 0 1-5.8-5.8z"/>
      <path fill="#f60" d="M770.7 736.9a2.4 2.4 0 1 1 2.3 2.4 2.3 2.3 0 0 1-2.3-2.4z"/>
      <path fill="none" stroke="#f6ffff" stroke-miterlimit="10" d="M374.4 668.6H84.1"/>
      <path fill="#f6ffff" d="M382.6 668.6a5.9 5.9 0 1 0-5.8 5.8 5.8 5.8 0 0 0 5.8-5.8z"/>
      <path fill="#f60" d="M379.1 668.6a2.4 2.4 0 1 0-2.3 2.4 2.3 2.3 0 0 0 2.3-2.4z"/>
      <path fill="none" stroke="#f6ffff" stroke-miterlimit="10" d="M744.7 495.6H967"/>
      <path fill="#f6ffff" d="M736.5 495.6a5.8 5.8 0 1 1 5.8 5.8 5.8 5.8 0 0 1-5.8-5.8z"/>
      <path fill="#f60" d="M739.9 495.6a2.4 2.4 0 1 1 2.4 2.4 2.3 2.3 0 0 1-2.4-2.4z"/>
      <g>
        <path fill="none" stroke="#f6ffff" stroke-miterlimit="10" d="M575.2 336.6h-84l-129.2 77H81.3"/>
        <path fill="#f6ffff" d="M579.9 336.6a5.8 5.8 0 1 0-5.8 5.8 5.8 5.8 0 0 0 5.8-5.8z"/>
        <path fill="#f60" d="M576.5 336.6a2.4 2.4 0 1 0-2.4 2.4 2.4 2.4 0 0 0 2.4-2.4z"/>
      </g>
      <text font-family="카페24 아네모네" font-size="22.371" letter-spacing=".5em" opacity=".27" style="mix-blend-mode:multiply" transform="translate(188.2 1144.1)">
        BITCAMP
      </text>
      <text fill="#fff" font-family="Montserrat-Black,Montserrat" font-size="24" letter-spacing=".3em" transform="translate(96.3 402.1)">
      	<a href="../member/signup.jsp" style="color:white !important;">MemberSignUp</a>
      </text>
      <text fill="#fff" font-family="Montserrat-Black,Montserrat" font-size="24" letter-spacing=".28em" transform="translate(858.4 483.9)">
        <a href="../goods/goods.do?m=list" style="color:white !important;">ProductList</a>
      </text>
      <text fill="#fff" font-family="Montserrat-Black,Montserrat" font-size="24" letter-spacing=".3em" transform="translate(101.4 654.5)">
       <a href="../member/member.do?m=list" style="color:white !important;">MemberList</a>
      </text>
      <text fill="#fff" font-family="Montserrat-Black,Montserrat" font-size="24" letter-spacing=".3em" transform="translate(893.6 788.4)">
        <a href="../board/board.do?m=list" style="color:white !important;">NoticeBoard</a>
      </text>
      <text fill="#fff" font-family="Montserrat-Black,Montserrat" font-size="24" letter-spacing=".3em" transform="translate(116.4 939.1)">
        <a href="../money/money.do?m=list" style="color:white !important;">SalesCheck</a>
      </text>
    </g>
    <g font-family="카페24 아네모네">
      <text class="services" fill="#fff" font-size="60" letter-spacing=".5em" transform="translate(590 208.3)" text-anchor="middle">
        베라 회원 관리페이지
      </text>
      <text class="in dn" fill="#fff" font-size="60" letter-spacing=".5em" transform="translate(590 208.3)" text-anchor="middle">
        INFRASTRUCTURE
      </text>
      <text class="pn dn" fill="#fff" font-size="60" letter-spacing=".5em" transform="translate(590 208.3)" text-anchor="middle">
        PLATFORM
      </text>
       <text class="fn dn" fill="#fff" font-size="60" letter-spacing=".5em" transform="translate(590 208.3)" text-anchor="middle">
        FUNCTIONS
      </text>
      <text class="aas dn" fill="#db1935" font-size="24" letter-spacing=".3em"  transform="translate(600 260.7)" text-anchor="middle">
        AS A SERVICE
      </text>
    </g>
</svg>
