package com.example.applemarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding
import com.example.applemarket.model.GoodsData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    val dataList = mutableListOf<GoodsData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // 더미 데이터
        dataList.add(
            GoodsData(
                R.drawable.sample1,
                "산진 한달된 선풍기 팝니다",
                "서울 서대문구 창천동",
                "이사가서 필요가 없어졌어요 급하게 내놓습니다",
                10000,
                "대현동",
                13,
                25,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample2,
                "김치냉장고",
                "인천 계양구 귤현동",
                "이사로인해 내놔요",
                870000,
                "아무개",
                5,
                1,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample3,
                "샤넬 카드지갑",
                "수성구 범어동",
                "고퀄지갑이구요\n사용감이 있어서 싸게 내어둡니다",
                970000,
                "명품조아",
                131,
                210,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample4,
                "금고",
                "해운대구 우제2동",
                "금고\n떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다",
                390000,
                "Nicole",
                72,
                41,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample5,
                "갤럭시Z플립3 팝니다",
                "연제구 연산제8동",
                "갤럭시 Z플립3 그린 팝니다\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!",
                210000,
                "절명",
                43,
                26,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample6,
                "프라다 복조리백",
                "수원시 영통구 원천동",
                "까임 오염없고 상태 깨끗합니다\n정품여부모름",
                1200000,
                "미니멀하게",
                78,
                61,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample7,
                "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                "남구 옥동",
                "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다.",
                210000,
                "굿리치",
                281,
                102,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample8,
                "샤넬 탑핸들 가방",
                "동래구 온천제2동",
                "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n + \"\n\" + \"색상 : 블랙\n\" + \"사이즈 : 25.5cm * 17.5cm * 8cm\n\" + \"구성 : 본품더스트\n\" + \"\n\" + \"급하게 돈이 필요해서 팝니다 ㅠ ㅠ",
                3800000,
                "난쉽",
                31,
                8,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample9,
                "4행정 엔진분무기 판매합니다.",
                "원주시 명륜2동",
                "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\n",
                50000,
                "알뜰한",
                5,
                2,
                false
            )
        )
        dataList.add(
            GoodsData(
                R.drawable.sample10,
                "셀린느 버킷 가방",
                "중구 동화동",
                "22년 신세계 대전 구매입니당\n + \"셀린느 버킷백\n\" + \"구매해서 몇번사용했어요\n\" + \"까짐 스크래치 없습니다.\n\" + \"타지역에서 보내는거라 택배로 진행합니당!\"",
                1350000,
                "똑때현",
                40,
                12,
                false
            )
        )


        val adapter = GoodsAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // 아이템 클릭시 detailActivity로 데이터 넘기면서 넘어감
        adapter.itemClick = object : GoodsAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, GoodsDetailActivity::class.java)
                intent.putExtra(Constants.ITEM_INDEX, position)
                intent.putExtra(Constants.ITEM_OBJECT, dataList[position]);
                activityResultLauncher.launch(intent)
            }
        }
        // 아이템 삭제
        adapter.itemLongClick = object : GoodsAdapter.ItemLongClick{
            override fun onLongClick(view: View, position: Int) {
                val dial = AlertDialog.Builder(this@MainActivity)
                dial.setIcon(R.drawable.chat)
                dial.setTitle("Delete")
                dial.setMessage("삭제하시겠습니까?")
                dial.setPositiveButton("확인"){
                    dialog, _ -> dataList.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }
                dial.setNegativeButton("취소"){
                    dialog, _ -> dialog.dismiss()
                }
                dial.show()
            }
        }



        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val itemIndex = it.data?.getIntExtra("itemIndex", 0 ) as Int
                val isLike = it.data?.getBooleanExtra("isLike", false) as Boolean

                if (isLike){
                    dataList[itemIndex].isLike = true
                    dataList[itemIndex].likeCnt += 1
                }else {
                    if (dataList[itemIndex].isLike) {
                        dataList[itemIndex].isLike = false
                        dataList[itemIndex].likeCnt -= 1
                    }
                }
                // 리사이클러뷰 아이템 갱신 코드
                adapter.notifyItemChanged(itemIndex)
            }
        }

        binding.ivNoti.setOnClickListener{
            Log.d("ButtonClickListener", "Button clicked!")
            notification()
        }


        // fab 클릭 시 스크롤 최상단 이동
        // 0.5초 동안 100% ~ 0%, 0% ~ 100% 로 이동
        val fadeIn = AlphaAnimation(0f, 1f).apply { duration = 500 }
        val fadeOut = AlphaAnimation(1f, 0f).apply { duration = 500 }
        var isTop = true

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.recyclerView.canScrollVertically(-1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                    binding.upButton.startAnimation(fadeOut)
                    binding.upButton.visibility = View.GONE
                    isTop = true
                }else{
                    if (isTop){
                        binding.upButton.visibility = View.VISIBLE
                        binding.upButton.startAnimation(fadeIn)
                        isTop = false
                    }
                }
            }
        })

        binding.upButton.setOnClickListener{
            //  fab 클릭 시 0번 아이템으로 이동
            binding.recyclerView.smoothScrollToPosition(0)
        }



    }

    // 뒤로가기 버튼 클릭 시

    override fun onBackPressed() {
        val fa = AlertDialog.Builder(this)
        fa.setIcon(R.drawable.chat)
        fa.setTitle("종료")
        fa.setMessage("종료하시겠습니까?")

        fa.setPositiveButton("확인"){
            dialog, _ ->
            finish()
        }
        fa.setNegativeButton("취소"){
            dialog, _ ->
            dialog.dismiss()
        }
        fa.show()
    }


    // 알림 로직
    fun notification(){
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // 26 버전 이상
            val channelId="one-channel"
            val channelName="My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        }else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }


        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("새로운 알림입니다.")
            setContentText("알림이 잘 보이시나요.")
        }

        manager.notify(11, builder.build())
    }

}


