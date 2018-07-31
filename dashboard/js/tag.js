<block>
  <div class="panel panel-{data.style}">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">{data.value}</div>
                                    <div>{data.title}!</div>
                                </div>
                            </div>
                        </div>
                      
                    </div>

  <script>
  
    this.data = opts;

    var _this = this;
    this.on('mount', function() {
    // right after the tag is mounted on the page
        console.log("tag header");
        
        TAGS.push(this);
        	        	
        
    })

    this.on('update', function() {
    // right after the tag is mounted on the page
        console.log("tag update");
          console.log(NoOfRequest);
          console.log(NoOfAccepted);
        
         _this.updateData();
        	        	
        
    })



    updateData()
    {
      if(this.data.key =="REQUEST")
      {
        this.data.value = NoOfRequest;
      }
      else
        if(this.data.key =="REVIEWED")
        {
          this.data.value = NoOfReviewed;
        }
      
      else
        this.data.value = NoOfAccepted;       
      
    }    
  </script>

</block>


<tabledetail>
    <table class="table table-bordered table-hover table-striped table-dark">
        <thead>
            <tr>
                <th>#</th>
                <th>Time</th>
                <th>Status</th>
              
            </tr>
        </thead>
        <tbody>
            <tr each={item in data} >
                <td>{item.idRequest}</td>
                <td>{item.date}</td>
                <td>{item.status}</td>
           
            </tr>
            
        </tbody>
    </table>
    
    <script>
  
    this.data = opts.data;
    this.idkey = opts.idkey;
    this.status = opts.status;
    var _this = this;
    this.on('mount', function() {
    // right after the tag is mounted on the page
        console.log(this.data);
     
       this.timer= setInterval(function(){
        	

        	  
        	 getByStatus(_this.status, function(data){
        		_this.updateData(data);
              });
        	
        	
        },2000,this.status);

       
    })

    updateData(data)
    {


       if(this.status == STATUS.PENDING)
        NoOfRequest = data.length;
       else if(this.status == STATUS.REVIEWED)
        NoOfReviewed = data.length;
       else
        NoOfAccepted = data.length;

      this.data = data;
      
      this.update();
      
      var tags = TAGS;
      
      for(var i=0;i<data.length;i++)
      {
        var mytag = tags[i];
        if(mytag) mytag.update();
      }
     

    }    
  </script>
    
</tabledetail>